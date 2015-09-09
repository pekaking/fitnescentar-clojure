(ns fitnescentar.teretane
  (:require [clojure.java.jdbc :as j]
            [clojure.java.jdbc.sql :as s]))

(def mysql-db {:subprotocol "mysql"
               :subname "//localhost:3306/ssa"
               :user "root"
               :pass " "})

(defn all []
  (j/query mysql-db
           (s/select * :teretana)))

(defn get [id]
  (j/query mysql-db
           (s/select * :teretana (s/where {:teretanaid id}))))

(defn create [params]
  (j/insert! mysql-db :teretana params))

(defn update [id params]
  (j/update! mysql-db :teretana params (s/where {:teretanaid id})))

(defn delete [id]
  (j/delete! mysql-db :teretana (s/where {:teretanaid id})))

