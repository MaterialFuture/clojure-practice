(ns  misc.weather
  (:require demo.core tupelo.core tupelo.test
            '[clj-http.client :as client])
  (:import [java.time ZonedDateTime ZoneId]))

;; Get geolocation
(require )

(defn get-location [api-key ip-address]
  (let [response (client/post "https://www.googleapis.com/geolocation/v1/geolocate"
                              {:form-params {:considerIp true
                                             :wifiAccessPoints []
                                             :cellTowers []}
                               :query-params {:key api-key}})]
    (get-in response [:body :location])))

(let [api-key "YOUR_API_KEY"
      ip-address "8.8.8.8"]
  (let [location (get-location api-key ip-address)]
    (println "Latitude:" (:lat location))
    (println "Longitude:" (:lng location))))


; Building request

;; Get info from ip for location
;; (def ipinf (shell "curl ipinfo.io"))
;; (print ipinf)

; Get datetime
(println (.format (.withZoneSameInstant (ZonedDateTime/now) 
                                        (ZoneId/of "America/Los_Angeles")) 
                  (java.time.format.DateTimeFormatter/ofPattern "HH:mm")))

; Get input or automatic for local NOAA code

; Display options for NOAA weather

