(ns colourizer.core
  (:gen-class))

(def ANSI-CODES
  {:reset "[0m"
   :bright "[1m"
   :blink-slow "[5m"
   :underline "[4m"
   :underline-off "[24m"
   :inverse "[7m"
   :inverse-off "[27m"
   :strikethrough "[9m"
   :strikethrough-off "[29m"

   :default "[39m"
   :white "[37m"
   :black "[30m"
   :red "[31m"
   :green "[32m"
   :blue "[34m"
   :yellow "[33m"
   :magenta "[35m"
   :cyan "[36m"

   :bg-default "[49m"
   :bg-white "[47m"
   :bg-black "[40m"
   :bg-red "[41m"
   :bg-green "[42m"
   :bg-blue "[44m"
   :bg-yellow "[43m"
   :bg-magenta "[45m"
   :bg-cyan "[46m"
   })

(defn- ansi [code]
  (get ANSI-CODES code))

(defn- highlight [text]
  (str \u001b (ansi :bg-red) text \u001b (ansi :reset)))

(defn -main [text]
  (doseq [line (line-seq (java.io.BufferedReader. *in*))] 
    (println (clojure.string/replace line text (highlight text)))))
