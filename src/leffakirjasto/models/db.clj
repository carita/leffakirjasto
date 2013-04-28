(ns leffakirjasto.models.db
  (:use korma.core
        [korma.db :only (defdb)])
  (:require [leffakirjasto.models.schema :as schema]))

(defdb db schema/db-spec)

(defentity movies)

(defn get-movies []
  (select movies))

(defn save-movie
  [name original_name year director]
  (insert movies
    (values {:name name
             :original_name original_name
             :year year
             :director director})))

;(defn get-user [id]
;  (first (select users
;                 (where {:id id})
;                 (limit 1))))

;(defn update-movie [id first-name last-name email]
;  (update movies
;  (set-fields {:first_name first-name
;               :last_name last-name
;               :email email})
;  (where {:id id})))
