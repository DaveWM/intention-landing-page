(ns intention-landing-page.core
  (:require [hiccup.core :as h]))


(def app-url "https://i.ntention.app")

(def fathom-script
  [:script "(function(f, a, t, h, o, m){
	a[h]=a[h]||function(){
		(a[h].q=a[h].q||[]).push(arguments)
	};
	o=f.createElement('script'),
	m=f.getElementsByTagName('script')[0];
	o.async=1; o.src=t; o.id='fathom-script';
	m.parentNode.insertBefore(o,m)
})(document, window, '//stats.lobster-writer.co.uk/tracker.js', 'fathom');
fathom('set', 'siteId', 'XVASS');
fathom('trackPageview');"])

(def play-store-badge
  [:a.play-badge {:href "https://play.google.com/store/apps/details?id=com.davidmartin.intention&pcampaignid=pcampaignidMKT-Other-global-all-co-prtnr-py-PartBadge-Mar2515-1"}
   [:img {:alt "Get it on Google Play" :src "https://play.google.com/intl/en_gb/badges/static/images/badges/en_badge_web_generic.png"}]])

(def head
  [:head
   [:link {:rel :stylesheet
           :href "styles/main.css"}]
   [:link {:rel :stylesheet
           :href "https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"}]
   [:link {:rel :icon
           :href "favicon.ico"}]
   [:title "Intention"]
   [:meta {:name "viewport"
           :content "width=device-width, initial-scale=1"}]
   fathom-script])

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
    [:div.row.justify-center.align-items-center
     [:div.col-6
      [:a {:href app-url
           :class "btn btn-primary btn-lg"}
       "Get Started"]]
     [:div.col-6 play-store-badge]]]
   [:div {:class "col-md-8"}
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
        [:div {:class "feature col-md text-center"}
         [:div.icon [:i {:class (str (:logo d) " fa-3x")}]]
         [:h3 (:title d)]
         [:p.lead.description (:description d)]])]]))

(def what-is-it
  [:section {:class "py-5 what-is-it"}
   [:div.row {:class "align-items-center"}
    [:div {:class "col-md-5"}
     [:img.diagram {:src "images/intention-dag.png"}]]
    [:div {:class "col-md-7"}
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

(def donate
  (let [bmc-btn [:a.bmc-button {:target "_blank" :href "https://www.buymeacoffee.com/davewm"} [:img {:src "https://cdn.buymeacoffee.com/buttons/bmc-new-btn-logo.svg" :alt "Buy me a coffee"}] [:span {:style "margin-left:15px;font-size:28px !important;"} "Buy me a coffee"]]]
    [:section {:class "py-5 donate"}
     [:h2 {:class "text-center pb-3 display-4"} "Donate"]
     [:div.row.align-items-center.justify-content-around
      [:div.col-md-6
       [:p.lead "Intention is developed and maintained by a sole developer.
     If you like Intention, please consider donating a small amount towards its development. Thank you."]]
      [:div.col-md-6.text-center.text-md-left
       bmc-btn]]]))

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
     donate
     support]]])


(defn main [& args]
  (println "Running...")
  (spit "public/index.html" (h/html page)))

(main)
