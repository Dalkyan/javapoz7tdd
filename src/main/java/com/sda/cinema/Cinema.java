package com.sda.cinema;

import com.sda.cinema.model.CinemaNotifierResponse;

public class Cinema {
    private final CinemaBookingService cinemaBookingService;
    private final CinemaNotifier cinemaNotifier;

    public Cinema(CinemaBookingService cinemaBookingService, CinemaNotifier cinemaNotifier) {
        this.cinemaBookingService = cinemaBookingService;
        this.cinemaNotifier = cinemaNotifier;
    }

    public CinemaBookingResponse bookMovie(CinemaMovie movie, int seat, CinemaUser user, CinemaChannel channel) {
        CinemaBookingStatus status = cinemaBookingService.bookSeat(movie, seat);
        if (!status.isStatus()) {
            CinemaBookingResponse failureResponse = new CinemaBookingResponse();
            switch (status.getStatusCode()) {
                case WRONG_SEAT_ID:
                    failureResponse.setMessage("Wybrano niepoprawny numer miejsca.");

                    break;
                case SEAT_ALREADY_BOOKED:
                    failureResponse.setMessage("Miejsce jest już zajęte.");
                    break;
                case INVALID_TYPE_OF_SEAT:
                    failureResponse.setMessage("To miejsce nie jest przeznaczone dla takich osób jak ty.");

                    break;
            } return failureResponse;
        }
        CinemaNotifierResponse response = cinemaNotifier.notify(user,channel,"Numer Twojego biletu to: bla-bla-666-6989");
        if (!response.isStatus()) {
            CinemaBookingResponse failureBookingResponse = new CinemaBookingResponse();
            switch (response.getStatusCode()) {
                case SERVER_ERROR:
                    failureBookingResponse.setMessage("System zjadł pański bilet");
                    break;
                case CHANNEL_NOT_SPECIFIED:
                    failureBookingResponse.setMessage("Nie podano nam sposobu wysłania biletu, więc nie mógł zostać wysłany.");
                    break;
            }
    return failureBookingResponse;
        }
        return new CinemaBookingResponse(true, "Miejsce zostało pomyślnie zarezerwowane");
    }
}
