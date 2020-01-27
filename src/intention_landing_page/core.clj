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
    [:h1 {:class "display-3"} "Intention"]
    [:p.lead "Plan and Achieve your Goals with Intention"]
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
    [:section {:class "py-5"}
     [:h2 {:class "text-center pb-3 display-4"} "Features"]
     [:div {:class "row align-items-top features"}
      (for [d data]
        [:div {:class "feature col-md col-sm-12 text-center"}
         [:div.icon [:i {:class (str (:logo d) " fa-3x")}]]
         [:h3 (:title d)]
         [:p.lead (:description d)]])]]))

(def what-is-it
  [:section {:class "py-5 what-is-it"}
   [:div.row {:class "align-items-center"}
    [:div {:class "col-md-5 col-sm-12"}
     [:img.diagram {:src "images/intention-dag.png"}]]
    [:div {:class "col-md-7 col-sm-12"}
     [:h2.pb-3.display-4 "What is Intention?"]
     [:p.lead
      "We all want to achieve certain things in life - you may want to start your own company, lose some weight, or become a millionaire.
       For most of us, goals like this are too big and daunting - where do you even begin? Intention can help you plan and achieve these goals."]
     [:p.lead
      "Intention helps you to break down your goals into actionable tasks, and visualise them in a diagram.
       You do this by arranging your goals and tasks (" [:i "intentions"] ") into a graph - an arrangement where each intention can depend on multiple other intentions.
       This allows you to easily see how small tasks relate to your high-level goals, and gives you visual feedback of how you are progressing."]
     [:p.lead
      "The acts of writing down your goals, splitting them up into manageable tasks, and getting feedback on your progress make it much more likely that you'll achieve your goals.
       This is supported by psychology research - see "
      [:a {:target "_blank" :href "https://www.dominican.edu/academics/lae/undergraduate-programs/psych/faculty/assets-gail-matthews/researchsummary2.pdf"} "here"] ", "
      [:a {:target "_blank" :href "http://www.scielo.br/pdf/refuem/v24n2/01.pdf"} "here"] ", and "
      [:a {:target "_blank" :href "https://www.sciencedirect.com/science/article/pii/S0065260106380021"} "here."]]]]])

(def support
  (let [contacts [{:icon "fa fa-twitter"
                   :href "https://twitter.com/DWMartin41"}
                  {:icon "fa fa-envelope"
                   :href "mailto:mail@davemartin.me?subject=Intention"}]]
    [:section {:class "py-5 support"}
     [:h2 {:class "text-center pb-3 display-4"} "Support"]
     [:div.contacts
      (for [contact contacts]
        [:a {:href (:href contact)
             :class "btn btn-outline-primary contact"
             :target "_blank"}
         [:i {:class (str (:icon contact) " fa-3x")}]])]]))

(def page
  [:html
   head
   [:body
    navbar
    [:div {:class "container"}
     hero
     what-is-it
     features
     support]]])


(defn main [& args]
  (println "Running...")
  (spit "public/index.html" (h/html page)))

(main)
