(ns fitnescentar.controller
  (:require [clostache.parser :as clostache]
            [fitnescentar.vezbaci :as vezbaci]
            [fitnescentar.teretane :as teretane]
            [fitnescentar.treneri :as treneri]
            [fitnescentar.treninzi :as treninzi]))

(defn read-template [template-name]
  (slurp (clojure.java.io/resource
           (str "views/" template-name ".mustache"))))

(defn render-template [template-file params]
  (clostache/render (read-template template-file) params))

(defn vezbaci []
  (render-template "vezbaci" {:vezbaci (vezbaci/all)}))

(defn index []
  (render-template "index" {:vezbaci (vezbaci/all)}))

(defn new []
  (render-template "new_vezbac" {:teretane (teretane/all)
                                 :treneri (treneri/all)}))

(defn edit [id]
  (render-template "edit_vezbac" {:teretane (teretane/all)
                                  :treneri (treneri/all)
                                  :vezbac (vezbaci/get id)}))

(defn teretane []
  (render-template "teretane" {:teretane (teretane/all)}))

(defn treneri []
  (render-template "treneri" {:treneri (treneri/all)}))


(defn treninzi []
  (render-template "treninzi" {:treninzi (treninzi/all)
                               :vezbaci (vezbaci/all)
                               :treneri (treneri/all)
                               :teretane (teretane/all)}))

(defn edit-trening [id]
  (render-template "edit_trening" {:trening (treninzi/get id)
                                   :vezbac (vezbaci/get id)}))



