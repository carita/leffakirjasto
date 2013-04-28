(ns leffakirjasto.routes.home
  (:use compojure.core)
  (:require [leffakirjasto.views.layout :as layout]
            [leffakirjasto.util :as util]))

(def movie)

(defn home-page []
  (layout/render
    "home.html" {:movies (movie)}))

(defn about-page []
  (layout/render
    "about.html" {:content (util/md->html "/md/docs.md")}))

(defn movie []
  '("Minority report", "Life", "Leijona kuningas", "Inglorious Basterds"))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/about" [] (about-page)))
