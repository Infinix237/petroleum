package com.example.blessing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blessing.repository.UtilisateurRepository;
import com.example.blessing.exception.ResourceNotException;
import com.example.blessing.model.Utilisateur;

@RestController
@RequestMapping("/api/v1")
public class UtilisateurController {
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	// get all users
	@GetMapping("/utilisateurs")
	public List<Utilisateur> getAllUtilisateur(){
		return utilisateurRepository.findAll();
	}
	
	// create users
	@PostMapping("/utilisateurs")
	public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur){
		return utilisateurRepository.save(utilisateur);
	}
	
	// get user by id
	@GetMapping("/utilisateurs/{id}")
	public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable(value = "id") long userId) throws ResourceNotException{
		Utilisateur utilisateur = utilisateurRepository.findById(userId)
				.orElseThrow(()-> new ResourceNotException("Utilisateur not found for this id :: " +userId));
		
		return ResponseEntity.ok().body(utilisateur);
	}
	
	// update user
	@PutMapping("/utilisateurs/{id}")
	public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable(value = "id") long userId,
			 @RequestBody Utilisateur utilisateurDetails) throws ResourceNotException{
		Utilisateur utilisateur = utilisateurRepository.findById(userId)
				.orElseThrow(()-> new ResourceNotException("Utilisateur not found for this id :: " +userId));
		
		utilisateur.setName(utilisateurDetails.getName());
		utilisateur.setSurname(utilisateurDetails.getSurname());
		utilisateur.setSexe(utilisateurDetails.getSexe());
		utilisateurRepository.save(utilisateur);
		return ResponseEntity.ok().body(utilisateur);	
	}
	
	// delete user
	@DeleteMapping("/utilisateurs/{id}")
	public ResponseEntity<?> deleteutilisateur(@PathVariable(value = "id") long userId) throws ResourceNotException{
		utilisateurRepository.findById(userId)
				.orElseThrow(()-> new ResourceNotException("Utilisateur not found for this id :: " +userId));
		
		utilisateurRepository.deleteById(userId);
		return ResponseEntity.ok().build();
	}
}
