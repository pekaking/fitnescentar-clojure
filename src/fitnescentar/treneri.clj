(ns fitnescentar.treneri
  (:require [clojure.java.jdbc :as j]
            [clojure.java.jdbc.sql :as s]))

(def mysql-db {:subprotocol "mysql"
               :subname "//localhost:3306/ssa"
               :user "root"
               :pass " "})

(defn all []
  (j/query mysql-db
           (s/select * :trener)))

(defn get [id]
  (j/query mysql-db
           (s/select * :trener (s/where {:trenerid id}))))

(defn create [params]
  (j/insert! mysql-db :trener params))

(defn update [id params]
  (j/update! mysql-db :trener params (s/where {:trenerid id})))

(defn delete [id]
  (j/delete! mysql-db :trener (s/where {:trenerid id})))

