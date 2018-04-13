package com.sda.cinema;

import com.sda.cinema.model.CinemaNotifierResponse;
import com.sda.cinema.model.CinemaNotifierResponseStatus;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class CinemaTest {
    @Test
    public void userCanBookMovieAndReceiveNotificationWithTicket(){
        //given
        CinemaBookingService cinemaBookingService = Mockito.mock(CinemaBookingService.class);
        Mockito.when(cinemaBookingService.bookSeat(Mockito.any(), Mockito.anyInt())).then(e -> new CinemaBookingStatus(true,null));

        CinemaNotifier cinemaNotifier = Mockito.mock(CinemaNotifier.class);
        Mockito.when(cinemaNotifier.notify(Mockito.any(), Mockito.any(), Mockito.anyString()))
                .then(s-> new CinemaNotifierResponse(true,null));

        Cinema cinema = new Cinema(cinemaBookingService, cinemaNotifier);

        //when
        CinemaBookingResponse response = cinema.bookMovie(null, 15, null, null);
        //then
        Assert.assertEquals("Miejsce zostało pomyślnie zarezerwowane",response.getMessage());
        Assert.assertTrue(response.isStatus());
        Mockito.verify(cinemaNotifier, Mockito.times(1));
    } @Test
    public void userCannotBookMovieBecauseSelectedSeatIsInvalid(){
        //given
        CinemaBookingService cinemaBookingService = Mockito.mock(CinemaBookingService.class);
        Mockito.when(cinemaBookingService.bookSeat(Mockito.any(), Mockito.anyInt())).then(e -> new CinemaBookingStatus(false, CinemaBookingStatusCode.WRONG_SEAT_ID));

        CinemaNotifier cinemaNotifier = Mockito.mock(CinemaNotifier.class);
        Mockito.when(cinemaNotifier.notify(Mockito.any(), Mockito.any(), Mockito.anyString()))
                .then(s-> new CinemaNotifierResponse(true,null));
        Cinema cinema = new Cinema(cinemaBookingService, cinemaNotifier);

        //when
        CinemaBookingResponse response = cinema.bookMovie(null, 15, null, null);
        //then
        Assert.assertEquals("Wybrano niepoprawny numer miejsca.",response.getMessage());
        Assert.assertFalse(response.isStatus());
    }
    @Test
    public void userCannotBookMovieBecauseSelectedSeatIsAlreadyBooked(){
        //given
        CinemaBookingService cinemaBookingService = Mockito.mock(CinemaBookingService.class);
        Mockito.when(cinemaBookingService.bookSeat(Mockito.any(), Mockito.anyInt())).then(e -> new CinemaBookingStatus(false, CinemaBookingStatusCode.SEAT_ALREADY_BOOKED));

        CinemaNotifier cinemaNotifier = Mockito.mock(CinemaNotifier.class);
        Mockito.when(cinemaNotifier.notify(Mockito.any(), Mockito.any(), Mockito.anyString()))
                .then(s-> new CinemaNotifierResponse(true,null));
        Cinema cinema = new Cinema(cinemaBookingService, cinemaNotifier);
        //when
        CinemaBookingResponse response = cinema.bookMovie(null, 69, null, null);
        //then
        Assert.assertFalse(response.isStatus());
        Assert.assertEquals("Miejsce jest już zajęte.",response.getMessage());
    }
    @Test
    public void serverError(){
        //given
        CinemaBookingService cinemaBookingService = Mockito.mock(CinemaBookingService.class);
        Mockito.when(cinemaBookingService.bookSeat(Mockito.any(), Mockito.anyInt())).then(e -> new CinemaBookingStatus(true, null));

        CinemaNotifier cinemaNotifier = Mockito.mock(CinemaNotifier.class);
        Mockito.when(cinemaNotifier.notify(Mockito.any(), Mockito.any(), Mockito.anyString()))
                .then(s-> new CinemaNotifierResponse(false, CinemaNotifierResponseStatus.SERVER_ERROR));
        Cinema cinema = new Cinema(cinemaBookingService, cinemaNotifier);
        //when
        CinemaBookingResponse response = cinema.bookMovie(null, 609, null, null);
        //then
        Assert.assertFalse(response.isStatus());
        Assert.assertEquals("System zjadł pański bilet",response.getMessage());
    }
    @Test
    public void userHaveNotProvidedContact(){
        //given
        CinemaBookingService cinemaBookingService = Mockito.mock(CinemaBookingService.class);
        Mockito.when(cinemaBookingService.bookSeat(Mockito.any(), Mockito.anyInt())).then(e -> new CinemaBookingStatus(true, null));

        CinemaNotifier cinemaNotifier = Mockito.mock(CinemaNotifier.class);
        Mockito.when(cinemaNotifier.notify(Mockito.any(), Mockito.any(), Mockito.anyString()))
                .then(s-> new CinemaNotifierResponse(false,CinemaNotifierResponseStatus.CHANNEL_NOT_SPECIFIED));
        Cinema cinema = new Cinema(cinemaBookingService, cinemaNotifier);
        //when
        CinemaBookingResponse response = cinema.bookMovie(null, 96, null, null);
        //then
        Assert.assertFalse(response.isStatus());
        Assert.assertEquals("Nie podano nam sposobu wysłania biletu, więc nie mógł zostać wysłany.",response.getMessage());
    }

}
