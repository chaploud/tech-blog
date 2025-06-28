(ns user
  (:require [nextjournal.clerk :as clerk]))

(defn start-dev []
  (clerk/serve! {:browse? true
                 :watch-paths ["notebooks"]
                 :host "127.0.0.1"
                 :port 7777}))

(defn build-static []
  (clerk/build! {:paths ["notebooks"] :out-path "public"}))

(defn -main []
  (start-dev))