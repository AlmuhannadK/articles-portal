package com.example.articlesportal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


// Load privileges for User (with Security Dep)

//
//@Component("userDetailsService")
//@RequiredArgsConstructor
//public class MyUserDetailsService implements UserDetailsService {
//
//    private final AccountService accountService;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Optional<Account> optionalAccount = this.accountService.findByEmail(email);
//        if ( !optionalAccount.isPresent() ) {
//            throw new UsernameNotFoundException("Account not found!");
//        }
//        Account account = optionalAccount.get();
//        // taking the authorities of the account and mapping them to this collection that will pass to UserDetails
//        List<GrantedAuthority> grantedAuthorities = account.getAuthorities().stream().map(authority -> new SimpleGrantedAuthority(authority.getName())).collect(Collectors.toList());
//        return new org.springframework.security.core.userdetails.User(account.getEmail(), account.getPassword(), grantedAuthorities);
//    }
//}