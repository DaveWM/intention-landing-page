(ns intention-landing-page.core
  (:require [hiccup.core :as h]))


(def head
  [:head [:link {:rel :stylesheet
                 :href "https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"}]])

(def navbar
  [:nav {:class "navbar navbar-light bg-primary"}
   [:a {:class "navbar-brand" :href "#"} "Intention"]])


(def page
  [:html
   head
   [:body
    navbar
    [:div {:class "container"}
     [:div {:class "row py-5 align-items-center justify-content-center"}
      [:div {:class "col-md-4"}
       [:h1 {:class "display-4"} "Intention"]
       [:p "Plan and Achieve your Goals with Intention"]
       [:a {:href "https://i.ntention.app"
            :class "btn btn-large btn-primary"}
        "Get Started"]]
      [:div {:class "col-md"}
       [:img {:src "/images/on-phone.png"
              :width "100%"}]]]
     [:div {:class "py-3"}
      [:h2 "Features"]]]]])


(defn main [& args]
  (spit "public/index.html" (h/html page)))

(main)
