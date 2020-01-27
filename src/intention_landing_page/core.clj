(ns intention-landing-page.core
  (:require [hiccup.core :as h]))


(def app-url "https://i.ntention.app")

(def head
  [:head
   [:link {:rel :stylesheet
           :href "styles/main.css"}]
   [:link {:rel :stylesheet
           :href "https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"}]])

(def navbar
  [:nav {:class "navbar navbar-light bg-primary"}
   [:a {:class "navbar-brand text-light" :href "#"}
    [:img {:src "/images/logo-white.svg" :class "logo"}]
    "Intention"]
   [:a {:href app-url :class "btn btn-outline-light"} "Go to App"]])

(def hero
  [:section {:class "row py-5 align-items-center justify-content-center"}
   [:div {:class "col-md-4 text-center text-md-left"}
    [:h1 {:class "display-4"} "Intention"]
    [:p "Plan and Achieve your Goals with Intention"]
    [:a {:href app-url
         :class "btn btn-large btn-primary"}
     "Get Started"]]
   [:div {:class "col-md"}
    [:img {:src "/images/on-phone.png"
           :width "100%"}]]])

(def features
  (let [data [{:logo "fa fas fa-share-alt"
               :title "Organise"
               :description "Break down your high-level goals into actionable steps"}
              {:logo "fa far fa-eye"
               :title "Visualise"
               :description "Visualise your goals, and the dependencies between them"}
              {:logo "fa fas fa-trophy"
               :title "Achieve"
               :description "Achieve your goals faster and more reliably"}]]
    [:div {:class "py-5"}
     [:h2 {:class "text-center pb-3"} "Features"]
     [:div {:class "row align-items-top features"}
      (for [d data]
        [:div {:class "feature col-md col-sm-12 text-center"}
         [:div.icon [:i {:class (str (:logo d) " fa-3x")}]]
         [:h4 (:title d)]
         [:p (:description d)]])]]))

(def page
  [:html
   head
   [:body
    navbar
    [:div {:class "container"}
     hero
     features]]])


(defn main [& args]
  (println "Running...")
  (spit "public/index.html" (h/html page)))

(main)
