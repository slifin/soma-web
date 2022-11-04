(ns soma-web.core
  (:require [ring.adapter.jetty :as jetty]
            [nexus.core :as ns]))

(ns/def web-start
  [{::keys [port handler]}]
  {}
  (fn []
    (jetty/run-jetty handler {:port port})))


(defn handler [request]
  {:status 200
   :body "Hello World!"})

(defn -main
  [& _]
  (println "Hello, World!"))


(defn start
  []
  (run-jetty handler {:port 80}))
