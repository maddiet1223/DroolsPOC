package com.maddie.DroolsComplexRule;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolTest {

    public static void main(String[] args) {
        DroolTest demo = new DroolTest();
        demo.executeBusinessRule();
    }

    public void executeBusinessRule() {
        try {
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("first-ksession-rule");

            PaymentOffers paymentOffer = new PaymentOffers();
            paymentOffer.setChannel("paytm");
            paymentOffer.setFestival("xmas");
            paymentOffer.setFirstTimeCustomer(true);

            kSession.insert(paymentOffer);
            kSession.fireAllRules();
         

            System.out.println("The cashback for channel " + paymentOffer.getChannel() + " is " + paymentOffer.getDiscount());
            
            ;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
