(ns fitnescentar.treninzi
  (:require [clojure.java.jdbc :as j]
            [clojure.java.jdbc.sql :as s]))

(def mysql-db {:subprotocol "mysql"
               :subname "//localhost:3306/ssa"
               :user "root"
               :pass " "})

(defn all []
  (j/query mysql-db
           ["select * from trening join vezbac on (trening.vezbacid = vezbac.id) join trener on (vezbac.trener=trener.trenerid) join teretana on (vezbac.teretana=teretana.teretanaid)"]))

(defn get [id]
  (first (j/query mysql-db
                  [(clojure.string/join ["select * from trening inner join vezbac on (trening.vezbacid = vezbac.id) where treningid=", id])])))

(defn create [params]
  (j/insert! mysql-db :trening params))

(defn update [id params]
  (j/update! mysql-db :trening params (s/where {:treningid id})))

(defn delete [id]
  (j/delete! mysql-db :trening (s/where {:treningid id})))
