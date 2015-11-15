package org.arquillian.hol.lab04.domain;

public enum Country
{
   UNKNOWN,
   POLAND,
   BELGIUM,
   SCOTLAND,
   SWITZERLAND;


   public String getLabel()
   {
      return this.name().toLowerCase();
   }
}
