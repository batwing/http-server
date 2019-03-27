package com.slowmo.http.dns;

import sun.net.spi.nameservice.NameService;
import sun.net.spi.nameservice.dns.DNSNameService;

import java.net.InetAddress;
import java.util.Scanner;

public class DnsLookup {
    public static void main(String args[]) throws Exception{
        System.out.println("Please write down the host-address you'd like to lookup:");
        Scanner scanner = new Scanner(System.in);
        String testHostAddress = scanner.next();
        NameService dns = new DNSNameService();
        InetAddress[] result = dns.lookupAllHostAddr(testHostAddress);
        for (InetAddress address: result) {
            System.out.println(address);
        }

        for (InetAddress address: result){
            System.out.println(address);
            System.out.println(" " + dns.getHostByAddr(address.getAddress()));
        }
    }
}
