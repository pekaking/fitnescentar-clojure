(ns fitnescentar.vezbaci
  (:refer-clojure :exclude [get])
  (:require [clojure.java.jdbc :as j]
            [clojure.java.jdbc.sql :as s]))

(def mysql-db {:subprotocol "mysql"
               :subname "//localhost:3306/ssa"
               :user "root"
               :pass " "})

(defn all []
  (j/query mysql-db
           ["select * from vezbac inner join trener on (vezbac.trener = trener.trenerid) 
inner join teretana on (vezbac.teretana = teretana.teretanaid) order by id"]))

(defn get [id]
  (first (j/query mysql-db
                  (s/select * :vezbac (s/where {:id id})))))

(defn create [params]
  (j/insert! mysql-db :vezbac params))

(defn update [id params]
  (j/update! mysql-db :vezbac params (s/where {:id id})))

(defn delete [id]
  (j/delete! mysql-db :vezbac (s/where {:id id})))



