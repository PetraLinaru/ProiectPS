package service.impl;

import Repository.UserRepository;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;
@Service
public class UserServiceImpl implements UserService {

   final UserRepository userRepository;

//aici am pus si operatiile crud pe doctor aka ma loghez si daca user.role=admin aleg ce fel de cont vreau sa creez(setez rol)
   //apoi userii vor fi tratati ca si donor/doc in functie de enum
   @Autowired
   public UserServiceImpl(UserRepository userRepository) {
      this.userRepository = userRepository;
   }

   @Override
   public User registerUser(User user) {
      User newUser=userRepository.save(user);
      return user;
   }

   @Override
   public User getUser(String verification) {
      return null;
   }

   @Override
   public User findUserByEmail(String email) {
      User found = userRepository.findUserByEmail(email);
      if (found!=null)
         return found;
      else return null;
   }

   @Override
   public User findMaybeExistingUser(String firstName, String lastName, String email)
   {
      User found=userRepository.findUserByEmailAndFirstNameAndLastName(email,firstName,lastName);
      if (found!=null)
         return found;
      else return null;
   }



   @Override
   public User loginUser(String password, String email) {
      User found =userRepository.findUserByEmailAndPassword(email,password);
      if (found!=null)
         return found;
      else return null;

   }

   @Override
   public User editUser(User newUser)
   {
      User renewed=userRepository.save(newUser);
      return renewed;
   }




}
