package org.arquillian.hol.lab05.ui.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.arquillian.hol.lab05.controller.BeerAdvisorController;
import org.arquillian.hol.lab05.domain.Beer;
import org.arquillian.hol.lab05.repository.BeerRepository;
import org.arquillian.hol.lab05.service.BeerService;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;

public class Deployments
{
   private static final String WEBAPP_SRC = "src/main/webapp";

   /**
    * In this case we have "feature complete" web app.
    */
   public static WebArchive create()
   {
      return addWebResourcesTo(ShrinkWrap.create(WebArchive.class, "beer-advisor.war"))
            .addPackages(true, Beer.class.getPackage(),
                               BeerService.class.getPackage(),
                               BeerAdvisorController.class.getPackage())
            .addPackages(true, BeerRepository.class.getPackage())
            .addAsResource("test-persistence.xml", "META-INF/persistence.xml");
   }

   private static WebArchive addWebResourcesTo(WebArchive archive)
   {
      final File webAppDirectory = new File(WEBAPP_SRC);
      for (File file : FileUtils.listFiles(webAppDirectory, null, true))
      {
         if (!file.isDirectory())
         {
            archive.addAsWebResource(file, file.getPath().substring(WEBAPP_SRC.length()));
         }
      }
      return archive;
   }
}
