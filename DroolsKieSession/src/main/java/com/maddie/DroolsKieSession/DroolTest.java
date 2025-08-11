package com.maddie.DroolsKieSession;

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

            PaymentOffer paymentOffer = new PaymentOffer();
            paymentOffer.setChannel("googlepay");

            kSession.insert(paymentOffer);
            kSession.fireAllRules();
         

            System.out.println("The cashback for channel " + paymentOffer.getChannel() + " is " + paymentOffer.getDiscount());
            
            ;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
