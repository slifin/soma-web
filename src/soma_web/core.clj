(ns soma-web.core
  (:require [ring.adapter.jetty :as jetty]
            [com.nivekuil.nexus :as nx]
            [clojure-ini.core :as ini]))

(nx/def web-server
  [{::keys [port root]}]
  {::nx/halt (fn [web] (.stop web))}
  (jetty/run-jetty (fn [_] root) {:port port :join? false}))

(nx/def root
  []
  {}
  {:status 200
   :body "Hello world!"})

(nx/def options
  []
  {}
  (ini/read-ini "config.ini"))


(defonce sys (nx/init #:soma-web.core{:port 8000}
                      [::web-server]))


(comment
 (nx/halt! sys)
 (nx/reset sys #:soma-web.core{:port 8000} [::web-server]))





