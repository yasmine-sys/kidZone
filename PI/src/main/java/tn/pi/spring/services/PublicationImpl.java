package tn.pi.spring.services;


import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.pi.spring.entity.Commentaire;
import tn.pi.spring.entity.Publication;
import tn.pi.spring.repository.PublicationRepository;
import tn.pi.spring.repository.UserRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


@Service
@Slf4j
public class PublicationImpl implements PublicationService {

	@Autowired
	PublicationRepository publicationRep;
	
	
	@Autowired
	UserRepository userRep;
	@Override
	public List<Publication> retrievAllPublications() {
		List<Publication> publications =null;
		try {
			log.info("In method retrievAllPublications : ");
			log.debug("Conenction à la base de données : ");
			publications = publicationRep.findAll();
			log.debug("Le nombre total de Stocks : " + publications.size());
			for (Publication publication : publications) 
			{
				log.debug(" Publication : " + publication.toString());
			}
			log.info("Out method retrievAllPublications without Errors");
		}
		catch (Exception e) {log.error("Error in retrievAllPublications : " + e);}
		return (publications);
	}
	
	@Override
	public String AddPublication(int user_id,Publication pub) throws Exception {
		// TODO Auto-generated method stub
		/*List<String> title = publicationRep.findpubtitle();
		List<String> pub_txt = publicationRep.findpubtxt();

		int b=0,c=0;
		for (int i = 1; i <= title.size(); i++) {
			if (pub.getTitle().equalsIgnoreCase(title.get(i-1))) {

				for (int j = 1; j <= pub_txt.size(); j++) {
					if (pub.getPublication_txt().equalsIgnoreCase(pub_txt.get(j-1))) {

						break;

					}
					else {
						if (j == pub_txt.size()) {
							userRep.findById(user_id).map(user -> {



								pub.setUser(user);


								publicationRep.save(pub);
								return user;

							}).get();
							return "publication added succesfully";
						}
					}
				}
				break;
			}
			else{
				if (i == title.size()) {
					userRep.findById(user_id).map(user -> {



						pub.setUser(user);


						publicationRep.save(pub);
						return user;

					}).get();
					return "publication added succesfully";
				}
			}
			
		}*/
		userRep.findById((long) user_id).map(u ->{
			pub.setUser(u);
			publicationRep.save(pub);
			return u;
		});
		return "pub added successfully";


	}


	@Override
	public List<Publication> RetrievePublication() {
		// TODO Auto-generated method stub
		List<Publication> pub = (List<Publication>) publicationRep.findAll();
		return pub;
	}

	@Override
	public void UpdatePublicationById(Publication pub, int id) {
		// TODO Auto-generated method stub

		this.publicationRep.save(pub);
	}


	@Override
	public void DeletePublication(int id) {
		// TODO Auto-generated method stub

		this.publicationRep.deleteById((long) id);

	}


	@Override
	public Publication GetPubById(int pubId) {
		// TODO Auto-generated method stub

		return publicationRep.findById((long) pubId).get();

	}
}


/*
	@Override
	public Publication addPublication(Publication c) {
		return publicationRepository.save(c);
	}

	@Override
	public void deletePublication(Long id) {
		// TODO Auto-generated method stub
		publicationRepository.deleteById(id);
	}

	@Override
	public Publication updatePublication(Publication c) {
		return publicationRepository.save(c);
	}

	@Override
	public Publication retrievePublication(Long id) {
		// TODO Auto-generated method stub
		//return null;
		return (publicationRepository.findById(id).get());
	}

	
	@Override
	public int getNombrePublicationJPQL() {
		return publicationRepository.countPublication();
	}

	@Override
	public List<Commentaire> findCommentaire(Long id) {
		return (List<Commentaire>) publicationRepository.findCommentaire(id);
	}

	@Override
	public List<Publication> getAllPublications() {
		return (List<Publication>)publicationRepository.findAll();
	}

	@Override
	public List<Publication> retrieveAllPublicationswithSorting(String filed) {
		 return  publicationRepository.findAll(Sort.by(Sort.Direction.ASC,filed));
	}

	@Override
	public List<Publication> searchPublicationByDate(Date date) {
			LocalDate d = LocalDate.now();
			Date dateDuJour = java.sql.Date.valueOf(d);
			if(date.after(dateDuJour )){
				System.out.println("Please Check Your Data .. date could not be after Today");
			}
			return publicationRepository.searchPublicationByDate(date);	
		}

	@Override
	public Page<Publication> findPublicationWithPagination(int offset, int pageSize) {
		Page<Publication> Publications = publicationRepository.findAll(PageRequest.of(offset, pageSize));
        return  Publications;
	}
}

	

	/*@Override
	public List<Publication> getPublicationsByUser(Long idUser) {
		return (List<Publication>) publicationRepository.getPublicationsByUser(idUser);
	}

*/

	

	





