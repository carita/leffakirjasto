(ns leffakirjasto.models.schema
  (:require [clojure.java.jdbc :as sql]
            [noir.io :as io]))

(def db-store "site.db")

(def db-spec {:classname "org.h2.Driver"
              :subprotocol "h2"
              :subname (str (io/resource-path) db-store)
              :user "sa"
              :password ""
              :naming {:keys clojure.string/lower-case
                       :fields clojure.string/upper-case}})
(defn initialized?
  "checks to see if the database schema is present"
  []
  (.exists (new java.io.File (str (io/resource-path) db-store ".h2.db"))))

(defn create-movies-table
  []
  (sql/with-connection db-spec
    (sql/create-table
      :movies
      [:id "INTEGER PRIMARY KEY AUTO_INCREMENT"]
      [:name "varchar(50)"]
      [:original_name "varchar(50)"]
      [:year "integer"]
      [:director "varchar(50)"])))

(defn create-tables
  "creates the database tables used by the application"
  []
  (create-movies-table))
