(ns leffakirjasto.routes.home
  (:use compojure.core)
  (:require [leffakirjasto.views.layout :as layout]
            [leffakirjasto.util :as util]
            [leffakirjasto.models.db :as db]))

(defn home-page []
  (layout/render
    "home.html" {:movies (db/get-movies)}))

(defn save-movie [name original_name year director]
  (do
    (db/save-movie name original_name year director)
    (home-page)))

(defroutes home-routes
  (GET "/" [] (home-page))
  (POST "/" [name original_name year director] (save-movie name original_name year director)))
