
SecurityController
- login(LoginDTO dto)
- register(RegisterDTO dto)
- (logout ? => FRONT)

UserController
@PostMapping("/activate")
- activate(@RequestBody String code)
- show(String id)

BookingController
(BookingStatusDTO : String id, String status)
- updateBookingStatus(@RequestBody BookingStatusDTO id) => changer le statut
- create(@RequestBody BookingDTO dto)
- show(String id)
- list()

ChargingStationController
- search / find ? (the zuper query to search everywhere from the searchbar in front #LeTrucQueKevinVeut)
- create(@RequestBody ChargingStationDTO dto)
- update(@RequestBody ChargingStationDTO dto)
- delete(@RequestBody String id)
- show(String id)
- list(Localisation localisation)

LocalisationController
- show(String id) ? (mostly shows from other entity)
- create(@RequestBody LocalisationDTO dto) 
- update(@RequestBody LocalisationDTO dto)

HourlyRateController
- show(String id)
- create(@RequestBody HourlyRate dto)
- update(@RequestBody HourlyRate dto)
- delete(@RequestBody HourlyRate dto)

FavoriteController
- handleAction(@RequestBody FavoriteId id) (=> EmbeddedId)

ReviewController
- create(@RequestBody ReviewDTO dto)
- update(@RequestBody ReviewDTO dto) ? (decision of changes only the content AND the rating ?)
- delete(Long id)
- list() => SELECT * FROM review WHERE rating >= 4.0 ORDER by rating DESC LIMIT 10;

PowerController
- list()
- create(@RequestBody PowerDTO dto)
- update(@RequestBody PowerDTO dto)
- delete(Long id)

MediaController
- create(@RequestBody PowerDTO dto)
- update(@RequestBody PowerDTO dto)
- delete(Long id)

UserReviewController
- create(@RequestBody UserReviewDTO dto)
- update(@RequestBody UserReviewDTO dto) ? (decision of changes only the content AND the rating ?)
- delete(Long id)

