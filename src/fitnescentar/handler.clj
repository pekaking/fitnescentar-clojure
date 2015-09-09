(ns fitnescentar.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.util.response :as resp]
            [fitnescentar.controller :as controller]
            [fitnescentar.teretane :as teretane]
            [fitnescentar.vezbaci :as vezbaci]
            [fitnescentar.treneri :as treneri]
            [fitnescentar.treninzi :as treninzi]))

;(defn foo
;  "I don't do a whole lot."
;  [x]
;  (println x "Hello, World!"))

(defroutes public-routes
  (GET "/" [] (controller/index))
  (GET "/vezbaci" [] (controller/vezbaci))
  (route/resources "/")
  (GET "/vezbaci/new" [] (controller/new))
  (GET "/vezbaci/:id/delete" [id]
       (do (vezbaci/delete id)
        (resp/redirect "/vezbaci")))
  (POST "/vezbaci/create" [& params]
        (do (vezbaci/create params)
         (resp/redirect "/vezbaci")))
  (POST "/vezbaci/:id/update" [& params]
       (do (vezbaci/update (:id params) params)
         (resp/redirect "/vezbaci")))
  (GET "/vezbaci/:id/edit" [id] (controller/edit id))
  (GET "/teretane" [] (controller/teretane))
  (POST "/teretane/create" [& params]
        (do (teretane/create params)
          (resp/redirect "/teretane")))
  (GET "/teretane/:id/delete" [id]
       (do (teretane/delete id)
         (resp/redirect "/teretane")))
  (GET "/treneri" [] (controller/treneri))
  (POST "/treneri/create" [& params]
        (do (treneri/create params)
          (resp/redirect "/treneri")))
  (GET "/treneri/:id/delete" [id]
       (do (treneri/delete id)
         (resp/redirect "/treneri")))
  (GET "/treninzi" [] (controller/treninzi))
  (POST "/treninzi/create" [& params]
        (do (treninzi/create params)
          (resp/redirect "/treninzi")))
  (GET "/treninzi/:id/edit" [id] (controller/edit-trening id))
  (POST "/treninzi/:id/update" [& params]
        (do (treninzi/update params)
          (resp/redirect "/treninzi")))
    (GET "/treninzi/:id/delete" [id]
       (do (treninzi/delete id)
         (resp/redirect "/treninzi"))))

(defroutes app-routes 
  public-routes 
  (route/not-found "404 Not Found"))

(def app 
  (handler/site app-routes))
