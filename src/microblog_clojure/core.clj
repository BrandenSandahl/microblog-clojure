(ns microblog-clojure.core
  (:require [clojure.string :as str] ;this brings in a new lib
            [clojure.walk :as walk] ;brings in walk lib 
            [compojure.core :as c]
            [ring.adapter.jetty :as j]
            [ring.middleware.params :as p]
            [hiccup.core :as h])
  (:gen-class))

(c/defroutes app
  (c/GET "/" request
    "Hello, world!"))


(defonce server (atom nil))

(defn -main []
  (when @server
    (.stop @server))
  (reset! server j/run-jetty app (:port 3000 :join? false)))
