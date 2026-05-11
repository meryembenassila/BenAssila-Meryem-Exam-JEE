package benassila.meryem.benassilameryem;

import benassila.meryem.benassilameryem.entities.*;
import benassila.meryem.benassilameryem.repositories.ClientRepository;
import benassila.meryem.benassilameryem.repositories.ContratRepository;
import benassila.meryem.benassilameryem.repositories.PaimentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class BenassilaMeryemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BenassilaMeryemApplication.class, args);}

    @Bean
    CommandLineRunner start(ClientRepository clientRepository, ContratRepository contratRepository , PaimentRepository paimentRepository){
        return args -> {



            Stream<String> noms = Stream.of("Hassan", "Yassine", "Aicha" ,"Mohammed");

            noms.forEach(name ->{

                Client client = new Client();
                client.setName(name);
                client.setEmail(name + "@gmail.com");
                clientRepository.save(client);
            });

            clientRepository.findAll().forEach(client -> {

                Contrat_Automobile contrat_automobile = new Contrat_Automobile();
                contrat_automobile.setClient(client);
                contrat_automobile.setStatusContrat(Status_Contrat.EN_COURS);
                contrat_automobile.setTaux(Math.random());
                contrat_automobile.setDate_souscription(new Date());
                contrat_automobile.setMobtant_cotisation(Math.random());
                contrat_automobile.setDate_validation(new Date());
                contrat_automobile.setDureé_contrat(Math.random());
                contrat_automobile.setMarque("Marque ");
                contrat_automobile.setNuméro_immatriculation(10L);
                contrat_automobile.setModele("Model");
                contratRepository.save(contrat_automobile);



                Contrat_Sante contrat_satnte = new Contrat_Sante();
                contrat_satnte.setClient(client);
                contrat_satnte.setStatusContrat(Status_Contrat.EN_COURS);
                contrat_satnte.setTaux(Math.random());
                contrat_satnte.setDate_souscription(new Date());
                contrat_satnte.setMobtant_cotisation(Math.random());
                contrat_satnte.setDate_validation(new Date());
                contrat_satnte.setDureé_contrat(Math.random());
                contrat_satnte.setNiveauCouverture(Math.random()< 0.33 ? Niveau_Couverture.BASIQUE:
                        Math.random() < 0.66 ? Niveau_Couverture.INTERMEDIARE :
                               Niveau_Couverture.PREMIUM );
                contrat_satnte.setNombre_personnes(10);

                contratRepository.save(contrat_satnte);


                Contrat_Habitation contratHabitation = new Contrat_Habitation();
                contratHabitation.setClient(client);
                contratHabitation.setStatusContrat(Status_Contrat.EN_COURS);
                contratHabitation.setTaux(Math.random());
                contratHabitation.setDate_souscription(new Date());
                contratHabitation.setMobtant_cotisation(Math.random());
                contratHabitation.setDate_validation(new Date());
                contratHabitation.setDureé_contrat(Math.random());
                contratHabitation.setStatusContrat(Math.random()< 0.33 ? Status_Contrat.EN_COURS:
                        Math.random() < 0.66 ? Status_Contrat.VALIDE : Status_Contrat.REALISE);
                contratHabitation.setAdress("Adress");
                contratHabitation.setSuperficie(Math.random());
              contratHabitation.setTypeLogement(Math.random()< 0.33 ? Type_Logement.APPARTEMENT:
                      Math.random() < 0.66 ? Type_Logement.APPARTEMENT :
                              Type_Logement.MAISON );
                contratRepository.save(contratHabitation);



            });






        };
    }

}
