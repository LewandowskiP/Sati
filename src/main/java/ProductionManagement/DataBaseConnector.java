/* 
 * Copyright 2018 Cafe Sati Polska.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ProductionManagement;

import GreenCoffeeClasses.CoffeeAttribute;
import GreenCoffeeClasses.CoffeeType;
import GreenCoffeeClasses.CoffeeOwner;
import GreenCoffeeClasses.PackType;
import GreenCoffeeClasses.CoffeeCountry;
import GreenCoffeeClasses.CoffeeGreen;
import GreenCoffeeClasses.Provider;
import ProductClasses.Aroma;
import ProductClasses.AromaType;
import ProductClasses.Cardboard;
import ProductClasses.CardboardType;
import ProductClasses.DirectPackage;
import ProductClasses.DirectPackageType;
import ProductClasses.InstantCoffeeMixPart;
import ProductClasses.InstantCoffeeMixRaport;
import ProductClasses.ProductDestination;
import ProductClasses.ProductType;
import ProductClasses.ReadyCoffee;
import ProductClasses.ReturnedProduct;
import ProductClasses.RoastAromaPart;
import ProductClasses.RoastGreenCoffeePart;
import ProductClasses.RoastRaport;
import ProductClasses.Sugar;
import ProductClasses.SugarType;
import ProductionClasses.Pallete;
import ProductionClasses.ProductionCoffee;
import ProductionClasses.ProductionCoffeeExternalReturn;
import ProductionClasses.ProductionCoffeeReturn;
import ProductionClasses.ProductionCoffeeSeek;
import ProductionClasses.ProductionLine;
import ProductionClasses.ProductionOrder;
import ProductionClasses.ProductionRaportCoffeeAssignment;
import ProductionClasses.ProductionRaportDirectPackage;

import ProductionClasses.ProductionRaportPart;
import SatiInterfaces.Details;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Przemysław
 */
public class DataBaseConnector {

    static final String CONFIG_URL = "hibernate.cfg.xml";
    SessionFactory sf = null;
    Session s = null;
    Transaction transation = null;

    public SessionFactory getSf() {
        return sf;
    }

    public DataBaseConnector() {
        Configuration cfg = new Configuration();
        cfg.configure(this.getClass().getClassLoader().getResource(CONFIG_URL));
        sf = cfg.buildSessionFactory();
    }

    public void flush() {
        s.flush();

    }

    public void refresh(Object o) {
        s.refresh(o);
    }

    public void clearSession() {
        openSession();
        s.close();
        sf.close();
        Configuration cfg = new Configuration();
        cfg.configure(this.getClass().getClassLoader().getResource(CONFIG_URL));
        sf = cfg.buildSessionFactory();
        s = sf.openSession();

    }

    public void openSession() {
        if (s != null) {
            if (s.isOpen()) {
                return;
            }
        }
        s = sf.openSession();
    }

    public void closeSession() {

        if (s != null) {
            if (s.isOpen()) {
                s.close();
            }
        }

    }

    public void rollbackTransation() {
        transation.rollback();

    }

    public void updateObject(Object object) {

        if (!s.isOpen()) {
            openSession();
        }
        Transaction t = s.beginTransaction();
        s.update(object);
        t.commit();

    }

    public void saveOrUpdateObject(Object object) {

        if (!s.isOpen()) {
            openSession();
        }
        Transaction t = s.beginTransaction();
        s.saveOrUpdate(object);
        t.commit();

    }

    public void saveObject(Object object) {

        if (!s.isOpen()) {
            openSession();
        }
        Transaction t = s.beginTransaction();
        s.save(object);
        t.commit();

    }

    public void deleteObject(Object object) {

        if (!s.isOpen()) {
            openSession();
        }
        Transaction t = s.beginTransaction();
        s.delete(object);
        t.commit();
    }

    public void startTransation() {

        if (!s.isOpen()) {
            openSession();
        }
        transation = s.beginTransaction();
    }

    public void saveTransation(Object object) {

        if (!s.isOpen()) {
            openSession();
        }
        s.saveOrUpdate(object);
    }

    public void updateTransation(Object object) {

        if (!s.isOpen()) {
            openSession();
        }
        s.update(object);
    }

    public void commitTransation() {

        if (!s.isOpen()) {
            openSession();
        }
        transation.commit();

    }

    public void deleteTransation(Object object) {

        if (!s.isOpen()) {
            openSession();
        }
        s.delete(object);
    }

    public void globalFix() {
        Query q;
        int i;
        String hql = "UPDATE producttype SET fileURLinstant = REPLACE(fileURLinstant, '\\\\192.168.17.10\\public\\', 'P:\\') WHERE productType_id >0;";
        s.createSQLQuery(hql).executeUpdate();
        hql = "UPDATE producttype SET productName = UPPER(productName) WHERE productType_id >0;";
        s.createSQLQuery(hql).executeUpdate();
        hql = "UPDATE producttype SET fileURL = REPLACE(fileURL, '\\\\\\\\192.168.17.10\\\\public\\\\', 'P:\\\\') WHERE productType_id >0; ";
        s.createSQLQuery(hql).executeUpdate();
        hql = "UPDATE producttype SET fileURL = REPLACE(fileURL, '\\\\\\\\DBC-SATICAFE\\\\Public\\\\', 'P:\\\\') WHERE productType_id >0;";
        s.createSQLQuery(hql).executeUpdate();
        hql = "UPDATE producttype SET fileURLinstant = REPLACE(fileURLinstant, '\\\\\\\\DBC-SATICAFE\\\\Public\\\\', 'P:\\\\') WHERE productType_id >0; ";
        s.createSQLQuery(hql).executeUpdate();
        hql = "UPDATE producttype  set productName = TRIM(productName)  where productType_id>0; ";
        s.createSQLQuery(hql).executeUpdate();
        hql = "UPDATE directpackagetype SET type = TRIM(type) WHERE directpackagetype >0;";
        s.createSQLQuery(hql).executeUpdate();
        hql = "UPDATE directpackagetype SET type = UPPER(type) WHERE directpackagetype >0;";
        s.createSQLQuery(hql).executeUpdate();
        hql = "UPDATE aromatype SET type = TRIM(type) WHERE aromatype_id >0;";
        s.createSQLQuery(hql).executeUpdate();
        hql = "UPDATE aromatype SET type = UPPER(type) WHERE aromatype_id >0;";
        s.createSQLQuery(hql).executeUpdate();
        hql = "UPDATE coffeetype SET type = TRIM(type) WHERE coffeetype_id >0;";
        s.createSQLQuery(hql).executeUpdate();
        hql = "UPDATE coffeetype SET type = UPPER(type) WHERE coffeetype_id >0;";
        s.createSQLQuery(hql).executeUpdate();
    }

    public Employee AuthorizeUser(String login, String password) {

        if (!s.isOpen()) {
            openSession();
        }
        Employee e = null;
        String hql = "FROM Employee E WHERE ( E.login = :empLogin AND E.password = :empPassword )";
        Query q = s.createQuery(hql);
        q.setParameter("empLogin", login);
        q.setParameter("empPassword", password);
        List result = q.list();
        if (result.size() > 0) {
            e = (Employee) result.get(0);
        }
        return e;
    }

    public Employee getUserWithLogin(String login) {
        if (!s.isOpen()) {
            openSession();
        }
        Employee e = null;
        String hql = "FROM Employee E WHERE E.login = :empLogin";
        Query q = s.createQuery(hql);
        q.setParameter("empLogin", login);
        List result = q.list();
        if (result.size() > 0) {
            e = (Employee) result.get(0);
        }
        return e;
    }

    public ArrayList<ProductionCoffee> getProductionCoffeeWithState(int state) {

        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<ProductionCoffee> alpc = new ArrayList<>();
        String hql = "FROM ProductionCoffee PC WHERE PC.state = :state";
        Query q = s.createQuery(hql);
        q.setParameter("state", state);
        List result = (List<ProductionCoffee>) q.list();
        alpc.addAll(result);
        for (ProductionCoffee pc : alpc) {
            Hibernate.initialize(pc.getProductType());
            Hibernate.initialize(pc.getProducedBy());
            Hibernate.initialize(pc.getProducedBy().getEmployeeID());
        }
        return alpc;

    }

    public ProductionRaportPart getLatestProductionRaportPart(ProductionLine productionLine, Employee employee) {
        ProductionRaportPart toReturn = null;
        if (!s.isOpen()) {
            openSession();
        }
        String hql = "FROM ProductionRaportPart PRP WHERE PRP.emp = :emp AND PRP.productionLine = :productionLine AND PRP.labTestState = :state ORDER BY id DESC LIMIT 1";
        Query q = s.createQuery(hql);
        q.setParameter("emp", employee);
        q.setParameter("productionLine", productionLine);
        q.setParameter("state", Global.PRODUCTION_RAPORT_PART_NEW);
        List result = (List<ProductionCoffee>) q.list();

        if (result.size() > 0) {
            toReturn = (ProductionRaportPart) result.get(0);
            Hibernate.initialize(toReturn.getPallete());
            for (Pallete p : toReturn.getPallete()) {
                Hibernate.initialize(p);
            }
            Hibernate.initialize(toReturn.getProductionRaportDirectPackage());
            for (ProductionRaportDirectPackage prdp : toReturn.getProductionRaportDirectPackage()) {
                Hibernate.initialize(prdp);
                Hibernate.initialize(prdp.getDirectPackage());
                Hibernate.initialize(prdp.getDirectPackage().getDirectPackageType());
            }
        }
        return toReturn;
    }

    public ArrayList<Pallete> getPalleteWithFromTo(Timestamp from, Timestamp to) {
        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<Pallete> alrr = new ArrayList<>();
        String hql = "FROM Pallete P WHERE P.prodDate < :to AND P.prodDate >= :from";
        Query q = s.createQuery(hql);
        q.setParameter("to", to).setParameter("from", from);
        List result = (List<Pallete>) q.list();
        alrr.addAll(result);
        return alrr;
    }

    public ArrayList<Pallete> getPalleteWithState(int state) {
        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<Pallete> alp = new ArrayList<>();
        String hql = "FROM Pallete P WHERE P.state = :state";
        Query q = s.createQuery(hql);
        q.setParameter("state", state);
        List result = (List<Pallete>) q.list();
        alp.addAll(result);
        return alp;
    }

    public ArrayList<CoffeeType> getCoffeeType() {

        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<CoffeeType> alct = new ArrayList<>();
        String hql = "FROM CoffeeType";
        Query q = s.createQuery(hql);
        List result = (List<CoffeeType>) q.list();
        alct.addAll(result);
        for (CoffeeType ct : alct) {

            Hibernate.initialize(ct.getCoffeeAttribute());
        }

        return alct;
    }

    public ArrayList<CoffeeOwner> getCoffeeOwner() {

        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<CoffeeOwner> alco = new ArrayList<>();
        String hql = "FROM CoffeeOwner";
        Query q = s.createQuery(hql);
        List result = (List<CoffeeOwner>) q.list();
        alco.addAll(result);
        return alco;
    }

    public ArrayList<CoffeeCountry> getCoffeeCountry() {

        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<CoffeeCountry> alcc = new ArrayList<>();
        String hql = "FROM CoffeeCountry";
        Query q = s.createQuery(hql);
        List result = (List<CoffeeCountry>) q.list();
        alcc.addAll(result);

        return alcc;
    }

    public ArrayList<PackType> getPackType() {

        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<PackType> alpt = new ArrayList<>();

        String hql = "FROM PackType";
        Query q = s.createQuery(hql);
        List result = (List<PackType>) q.list();

        alpt.addAll(result);
        return alpt;
    }

    public ArrayList<CoffeeGreen> getCoffeeGreen() {

        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<CoffeeGreen> alcg = new ArrayList<>();
        String hql = "FROM CoffeeGreen";
        Query q = s.createQuery(hql);
        List result = (List<CoffeeGreen>) q.list();
        alcg.addAll(result);
        s.close();
        return alcg;
    }

    public ArrayList<AromaType> getAromaType() {

        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<AromaType> alat = new ArrayList<>();
        String hql = "FROM AromaType";
        Query q = s.createQuery(hql);
        List result = (List<AromaType>) q.list();
        alat.addAll(result);
        return alat;
    }

    public ArrayList<ProductionLine> getProductionLine() {

        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<ProductionLine> alat = new ArrayList<>();
        String hql = "FROM ProductionLine";
        Query q = s.createQuery(hql);
        List result = (List<ProductionLine>) q.list();
        alat.addAll(result);
        return alat;
    }

    public ArrayList<CoffeeAttribute> getCoffeeAttribute() {

        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<CoffeeAttribute> alca = new ArrayList<>();
        String hql = "FROM CoffeeAttribute";
        Query q = s.createQuery(hql);
        List result = (List<CoffeeAttribute>) q.list();
        alca.addAll(result);
        for (CoffeeAttribute ca : alca) {
            Hibernate.initialize(ca.getCoffeeType());
        }
        return alca;
    }

    public ArrayList<ProductDestination> getProductDestination() {

        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<ProductDestination> alpd = new ArrayList<>();
        String hql = "FROM ProductDestination";
        Query q = s.createQuery(hql);
        List result = (List<ProductDestination>) q.list();
        alpd.addAll(result);

        return alpd;
    }

    public ArrayList<Provider> getProvider() {

        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<Provider> alp = new ArrayList<>();
        String hql = "FROM Provider";
        Query q = s.createQuery(hql);
        List result = (List<Provider>) q.list();
        alp.addAll(result);

        return alp;
    }

    public ArrayList<CoffeeGreen> getCoffeeGreenToExamine() {

        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<CoffeeGreen> alcg = new ArrayList<>();
        String hql = "FROM CoffeeGreen C WHERE C.state = :state";
        Query q = s.createQuery(hql);
        q.setParameter("state", Global.COFFEE_GREEN_TO_EXAMINE);
        List result = (List<CoffeeGreen>) q.list();
        alcg.addAll(result);

        return alcg;
    }

    public ArrayList<Aroma> getAromaToExamine() {

        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<Aroma> ala = new ArrayList<>();
        String hql = "FROM Aroma A WHERE A.state = :state";
        Query q = s.createQuery(hql);
        q.setParameter("state", Global.TO_EXAMINE);
        List result = (List<Aroma>) q.list();
        ala.addAll(result);

        return ala;
    }

    public ArrayList<CoffeeGreen> getCoffee() {

        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<CoffeeGreen> alcg = new ArrayList<>();
        String hql = "FROM CoffeeGreen C";
        Query q = s.createQuery(hql);
        List result = (List<CoffeeGreen>) q.list();
        alcg.addAll(result);

        return alcg;
    }

    public ArrayList<Aroma> getAroma() {

        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<Aroma> ala = new ArrayList<>();
        String hql = "FROM Aroma A";
        Query q = s.createQuery(hql);
        List result = (List<Aroma>) q.list();
        ala.addAll(result);

        return ala;
    }

    public ArrayList<ProductType> getProductTypeGroupByNameType() {

        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<ProductType> alpt = new ArrayList<>();
        String hql = "FROM ProductType GROUP BY productName ,type";
        Query q = s.createQuery(hql);
        List result = (List<ProductType>) q.list();
        alpt.addAll(result);
        return alpt;

    }

    public ArrayList<ProductType> getProductTypeGroupByNameTypeFilter(String filter) {

        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<ProductType> alpt = new ArrayList<>();
        String hql = "FROM ProductType PT WHERE PT.productName LIKE :filter GROUP BY productName ,type";
        Query q = s.createQuery(hql);
        q.setParameter("filter", "%" + filter + "%");
        List result = (List<ProductType>) q.list();
        alpt.addAll(result);
        return alpt;

    }

    public void updateProductName(ProductType old, String newName) {
        if (!s.isOpen()) {
            openSession();
        }
        String hql = "UPDATE ProductType SET productName = :newName WHERE productName = :oldName AND type = :oldType";
        Query q = s.createQuery(hql)
                .setParameter("newName", newName)
                .setParameter("oldName", old.getProductName())
                .setParameter("oldType", old.getType());
        int i = q.executeUpdate();
    }

    public ArrayList<ProductType> getProductType() {

        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<ProductType> alpt = new ArrayList<>();
        String hql = "FROM ProductType";
        Query q = s.createQuery(hql);
        List result = (List<ProductType>) q.list();
        alpt.addAll(result);

        return alpt;
    }

    public String getMaxLabIdCoffeeGreen() {

        if (!s.isOpen()) {
            openSession();
        }
        String hql = "SELECT CG FROM CoffeeGreen CG WHERE CG.labId = (SELECT MAX(labId) From CoffeeGreen)";
        Query q = s.createQuery(hql);
        List<CoffeeGreen> result = (List<CoffeeGreen>) q.list();
        if (result.isEmpty()) {
            return null;
        }
        CoffeeGreen cg = result.get(0);
        System.out.println(cg.getLabId());
        return cg.getLabId();
    }

    public String getMaxLabIdAroma() {

        if (!s.isOpen()) {
            openSession();
        }
        String hql = "SELECT A FROM Aroma A WHERE A.labId = (SELECT MAX(labId) From Aroma)";
        Query q = s.createQuery(hql);
        List<Aroma> result = (List<Aroma>) q.list();
        if (result.isEmpty()) {
            return null;
        }
        Aroma a = result.get(0);
        System.out.println(a.getLabId());
        return a.getLabId();
    }

    public int getProductTypeLastVersion(ProductType pt) {

        if (!s.isOpen()) {
            openSession();
        }
        String hql = "SELECT max(version) FROM ProductType PT WHERE PT.productName = :name AND PT.type = :type";
        Query q = s.createQuery(hql).setParameter("name", pt.getProductName()).setParameter("type", pt.getType());
        List result = q.list();
        int ver = (Integer) result.get(0);
        return ver;
    }

    public ArrayList<CoffeeGreen> getCoffeeGreenWithCoffeeType(CoffeeType selectedCoffeeType) {

        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<CoffeeGreen> alcg = new ArrayList<>();
        String hql = "FROM CoffeeGreen C WHERE C.coffeeType = :coffeeType AND C.state = :state";
        Query q = s.createQuery(hql);
        q.setParameter("coffeeType", selectedCoffeeType);
        q.setParameter("state", Global.COFFEE_GREEN_READY_TO_ROAST);
        List result = (List<CoffeeGreen>) q.list();
        alcg.addAll(result);
        for (CoffeeGreen cg : alcg) {
            Hibernate.initialize(cg.getPackType());
            Hibernate.initialize(cg.getCoffeeType());
            Hibernate.initialize(cg.getProvider());
            Hibernate.initialize(cg.getCoffeeType().getCoffeeAttribute());
        }
        return alcg;
    }

    public ArrayList<CoffeeGreen> getCoffeeGreenWithCoffeeTypeNoState(CoffeeType selectedCoffeeType) {

        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<CoffeeGreen> alcg = new ArrayList<>();
        String hql = "FROM CoffeeGreen C WHERE C.coffeeType = :coffeeType";
        Query q = s.createQuery(hql);
        q.setParameter("coffeeType", selectedCoffeeType);
        List result = (List<CoffeeGreen>) q.list();
        alcg.addAll(result);
        for (CoffeeGreen cg : alcg) {
            Hibernate.initialize(cg.getPackType());
            Hibernate.initialize(cg.getCoffeeType());
            Hibernate.initialize(cg.getProvider());
            Hibernate.initialize(cg.getCoffeeType().getCoffeeAttribute());
        }
        return alcg;
    }

    public ArrayList<Aroma> getAromaWithAromaType(AromaType selectedAromaType) {

        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<Aroma> ala = new ArrayList<>();
        String hql = "FROM Aroma C WHERE C.aromaType = :aromaType AND C.state = :state";
        Query q = s.createQuery(hql);
        q.setParameter("aromaType", selectedAromaType);
        q.setParameter("state", Global.READY_TO_USE);
        List result = (List<Aroma>) q.list();
        ala.addAll(result);
        for (Aroma a : ala) {
            Hibernate.initialize(a.getProvider());
            Hibernate.initialize(a.getAromaType());

        }
        return ala;
    }

    public ArrayList<Aroma> getAromaWithAromaTypeNoState(AromaType selectedAromaType) {

        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<Aroma> ala = new ArrayList<>();
        String hql = "FROM Aroma C WHERE C.aromaType = :aromaType";
        Query q = s.createQuery(hql);
        q.setParameter("aromaType", selectedAromaType);
        List result = (List<Aroma>) q.list();
        ala.addAll(result);
        for (Aroma a : ala) {
            Hibernate.initialize(a.getProvider());
            Hibernate.initialize(a.getAromaType());
        }
        return ala;
    }

    public CoffeeGreen getCoffeeGreenWithLabId(Object valueAt) {

        if (!s.isOpen()) {
            openSession();
        }
        CoffeeGreen cg;

        String hql = "FROM CoffeeGreen C WHERE C.labId = :valueAt";
        Query q = s.createQuery(hql);
        q.setParameter("valueAt", valueAt);
        List result = (List<CoffeeGreen>) q.list();
        if (result.isEmpty()) {
            return null;
        }
        cg = (CoffeeGreen) result.get(0);

        Hibernate.initialize(cg.getPackType());
        Hibernate.initialize(cg.getCoffeeType());
        Hibernate.initialize(cg.getCoffeeType().getCoffeeAttribute());

        return cg;
    }

    public Aroma getAromaWithLabId(Object valueAt) {

        if (!s.isOpen()) {
            openSession();
        }
        Aroma a;
        String hql = "FROM Aroma A WHERE A.labId = :valueAt";
        Query q = s.createQuery(hql);
        q.setParameter("valueAt", valueAt);
        List result = (List<Aroma>) q.list();
        if (result.isEmpty()) {
            return null;
        }

        a = (Aroma) result.get(0);

        return a;
    }

    public ProductionCoffeeExternalReturn getProductionCoffeeExternalReturnWithLabId(String text) {
        if (!s.isOpen()) {
            openSession();
        }
        ProductionCoffeeExternalReturn a;
        String hql = "FROM ProductionCoffeeExternalReturn A WHERE A.labId = :valueAt";
        Query q = s.createQuery(hql);
        q.setParameter("valueAt", text);
        List result = (List<ProductionCoffeeExternalReturn>) q.list();
        if (result.isEmpty()) {
            return null;
        }

        a = (ProductionCoffeeExternalReturn) result.get(0);

        //  s.close();
        return a;
    }

    public ArrayList<ProductType> getProductVersions(ProductType pt) {

        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<ProductType> alpt = new ArrayList<>();
        String hql = "FROM ProductType PT WHERE PT.productName = :name AND PT.type = :type";
        Query q = s.createQuery(hql).setParameter("name", pt.getProductName()).setParameter("type", pt.getType());
        List result = (List<ProductType>) q.list();
        alpt.addAll(result);
        return alpt;
    }

    public ArrayList<ProductionCoffeeSeek> getProductionCoffeeSeekWithEmployee(Employee emp) {

        if (!s.isOpen()) {
            openSession();
        }

        ArrayList<ProductionCoffeeSeek> alpcs = new ArrayList<>();
        String hql = "FROM ProductionCoffeeSeek PCS WHERE PCS.seekedBy = :emp";
        Query q = s.createQuery(hql).setParameter("emp", emp);
        List result = (List<ProductionCoffeeSeek>) q.list();
        alpcs.addAll(result);
        return alpcs;

    }

    public ArrayList<ProductionRaportPart> getProductionRaportPartWithBatchInfo(String batchInfo) {
        ArrayList<ProductionRaportPart> alprp = new ArrayList<>();
        if (!s.isOpen()) {
            openSession();
        }
        String hql = "FROM ProductionRaportPart PRP WHERE PRP.batchInfo = :batchInfo";
        Query q = s.createQuery(hql).setParameter("batchInfo", batchInfo);
        List result = (List<ProductionRaportPart>) q.list();
        if (!result.isEmpty()) {
            alprp.addAll(result);
        }
        return alprp;

    }

    public String getMaxLabIdProductionCoffeeExternalReturn() {
        if (!s.isOpen()) {
            openSession();
        }
        String hql = "FROM ProductionCoffeeExternalReturn PCER WHERE PCER.labId = (SELECT MAX(labId) From ProductionCoffeeExternalReturn)";
        Query q = s.createQuery(hql);
        List<ProductionCoffeeExternalReturn> result = (List<ProductionCoffeeExternalReturn>) q.list();
        if (result.isEmpty()) {
            return null;
        }
        ProductionCoffeeExternalReturn pcer = result.get(0);
        System.out.println(pcer.getLabId());
        return pcer.getLabId();
    }

    public ArrayList<ProductionCoffeeExternalReturn> getProductionCoffeeExternalReturnToExamine() {
        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<ProductionCoffeeExternalReturn> alpcer = new ArrayList<>();
        String hql = "FROM ProductionCoffeeExternalReturn PCER WHERE PCER.state = :state";
        Query q = s.createQuery(hql);
        q.setParameter("state", Global.PRODUCTION_COFFEE_EXTERNAL_TO_EXAMINE);
        List result = (List<ProductionCoffeeExternalReturn>) q.list();
        alpcer.addAll(result);
        for (ProductionCoffeeExternalReturn pcer : alpcer) {
            Hibernate.initialize(pcer.getProductionRaportPart());
            Hibernate.initialize(pcer.getProductionRaportPart().getProductType());
            Hibernate.initialize(pcer.getLabTest());
            Hibernate.initialize(pcer.getProductionRaportPart().getProductType().getProductName());
        }
        return alpcer;
    }

    public ArrayList<ProductionRaportPart> getProductsBlocked() {

        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<ProductionRaportPart> alprp = new ArrayList<>();
        String hql = "FROM ProductionRaportPart PRP WHERE PRP.labTestState = :state";
        Query q = s.createQuery(hql);
        q.setParameter("state", Global.PRODUCTION_RAPORT_PART_BLOCKED);
        List result = (List<ProductionRaportPart>) q.list();
        alprp.addAll(result);
        for (ProductionRaportPart prp : alprp) {

            Hibernate.initialize(prp.getProductType());
            Hibernate.initialize(prp.getProductionRaportCoffeeAssignment());
            for (ProductionRaportCoffeeAssignment prca : prp.getProductionRaportCoffeeAssignment()) {
                Hibernate.initialize(prca);
                Hibernate.initialize(prca.getProductionCoffee());
                Hibernate.initialize(prca.getProductionRaportPart());
            }
        }
        return alprp;
    }

    public ArrayList<ProductionRaportPart> getProductsToExamine() {
        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<ProductionRaportPart> alprp = new ArrayList<>();
        String hql = "FROM ProductionRaportPart PRP WHERE PRP.labTestState = :waiting OR PRP.labTestState = :block";
        Query q = s.createQuery(hql);
        q.setParameter("waiting", Global.PRODUCTION_RAPORT_PART_WAITING);
        q.setParameter("block", Global.PRODUCTION_RAPORT_PART_BLOCKED);
        List result = (List<ProductionRaportPart>) q.list();
        alprp.addAll(result);
        for (ProductionRaportPart prp : alprp) {

            Hibernate.initialize(prp.getProductType());
            Hibernate.initialize(prp.getProductionRaportCoffeeAssignment());
            for (ProductionRaportCoffeeAssignment prca : prp.getProductionRaportCoffeeAssignment()) {
                Hibernate.initialize(prca);
                Hibernate.initialize(prca.getProductionCoffee());
                Hibernate.initialize(prca.getProductionRaportPart());
            }
        }
        return alprp;
    }

    public ArrayList<Pallete> getProductsToStore() {
        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<Pallete> alprp = new ArrayList<>();
        String hql = "FROM Pallete P WHERE P.state = 2";
        Query q = s.createQuery(hql);
        List result = (List<Pallete>) q.list();
        alprp.addAll(result);
        return alprp;
    }

    public ArrayList<ProductionRaportPart> getProductsToAccept() {
        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<ProductionRaportPart> alprp = new ArrayList<>();
        String hql = "FROM ProductionRaportPart PRP WHERE PRP.labTestState >= :state";
        Query q = s.createQuery(hql);
        q.setParameter("state", Global.PRODUCTION_RAPORT_PART_WAITING);
        List result = (List<ProductionRaportPart>) q.list();
        alprp.addAll(result);
        for (ProductionRaportPart prp : alprp) {
            Hibernate.initialize(prp.getProductType());
            Hibernate.initialize(prp.getProductionRaportCoffeeAssignment());
            for (ProductionRaportCoffeeAssignment prca : prp.getProductionRaportCoffeeAssignment()) {
                Hibernate.initialize(prca);
                Hibernate.initialize(prca.getProductionCoffee());
                Hibernate.initialize(prca.getProductionRaportPart());
            }
        }
        return alprp;
    }

    public ArrayList<ProductionRaportPart> getHalfProductsToAccept() {
        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<ProductionRaportPart> alprp = new ArrayList<>();
        String hql = "FROM ProductionRaportPart PRP WHERE PRP.labTestState >= :state AND PRP.type = 3";
        Query q = s.createQuery(hql);
        q.setParameter("state", Global.PRODUCTION_RAPORT_PART_WAITING);
        List result = (List<ProductionRaportPart>) q.list();
        alprp.addAll(result);
        for (ProductionRaportPart prp : alprp) {
            Hibernate.initialize(prp.getProductType());
            Hibernate.initialize(prp.getProductionRaportCoffeeAssignment());
            for (ProductionRaportCoffeeAssignment prca : prp.getProductionRaportCoffeeAssignment()) {
                Hibernate.initialize(prca);
                Hibernate.initialize(prca.getProductionCoffee());
                Hibernate.initialize(prca.getProductionRaportPart());
            }
        }
        return alprp;
    }

    public ArrayList<RoastRaport> getRoastRaportWithCoffeeGreen(CoffeeGreen cg) {

        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<RoastRaport> alrr = new ArrayList<>();
        String hql = "SELECT DISTINCT roastRaport FROM RoastGreenCoffeePart RGCP WHERE RGCP.coffeeGreen = :cg";
        Query q = s.createQuery(hql);
        q.setParameter("cg", cg);
        List result = (List<RoastRaport>) q.list();
        alrr.addAll(result);
        for (RoastRaport rr : alrr) {
            Hibernate.initialize(rr);
            Hibernate.initialize(rr.getProductionCoffee());
            Hibernate.initialize(rr.getProductionCoffee().getProductType());

            if (rr.getRoastAromaPart() != null) {
                Hibernate.initialize(rr.getRoastAromaPart());
                for (RoastAromaPart rap : rr.getRoastAromaPart()) {
                    Hibernate.initialize(rap.getAroma());
                    Hibernate.initialize(rap.getAroma().getAromaType());
                }
            }

            Hibernate.initialize(rr.getRoastGreenCoffeePart());
            for (RoastGreenCoffeePart rgcp : rr.getRoastGreenCoffeePart()) {
                Hibernate.initialize(rgcp.getCoffeeGreen());
                Hibernate.initialize(rgcp.getCoffeeGreen().getCoffeeType());
                Hibernate.initialize(rgcp.getCoffeeGreen().getCoffeeType().getCoffeeAttribute());

            }
            Hibernate.initialize(rr.getRoastPart());

        }

        return alrr;
    }

    public ArrayList<ProductionRaportPart> getProductionRaportPartWithProductionCoffee(ProductionCoffee pc) {
        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<ProductionRaportPart> alprp = new ArrayList<>();
        String hql = "SELECT DISTINCT productionRaportPart FROM ProductionRaportCoffeeAssignment PRCA WHERE PRCA.productionCoffee = :pc";
        Query q = s.createQuery(hql);
        q.setParameter("pc", pc);
        List result = (List<ProductionRaportPart>) q.list();
        alprp.addAll(result);
        for (ProductionRaportPart prp : alprp) {

            Hibernate.initialize(prp.getProductType());
            Hibernate.initialize(prp.getProductionRaportCoffeeAssignment());
            for (ProductionRaportCoffeeAssignment prca : prp.getProductionRaportCoffeeAssignment()) {
                Hibernate.initialize(prca);
                Hibernate.initialize(prca.getProductionCoffee());
                Hibernate.initialize(prca.getProductionRaportPart());
            }
        }
        return alprp;

    }

    public ArrayList<InstantCoffeeMixRaport> getInstantCoffeeMixRaportWithCoffeeGreen(CoffeeGreen cg) {
        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<InstantCoffeeMixRaport> alicmr = new ArrayList<>();
        String hql = "SELECT DISTINCT instantCoffeeMixRaport FROM InstantCoffeeMixPart ICMP WHERE ICMP.coffeeGreen= :cg";
        Query q = s.createQuery(hql).setParameter("cg", cg);
        List<InstantCoffeeMixRaport> result = (List<InstantCoffeeMixRaport>) q.list();
        alicmr.addAll(result);
        for (InstantCoffeeMixRaport icmr : alicmr) {
            Hibernate.initialize(icmr.getProductionCoffee());
            Hibernate.initialize(icmr.getProductionCoffee().getProductType());
            Hibernate.initialize(icmr.getMixedBy());
            Hibernate.initialize(icmr.getInstantCoffeeMixPart());
            for (InstantCoffeeMixPart icmp : icmr.getInstantCoffeeMixPart()) {
                Hibernate.initialize(icmp.getCoffeeGreen());
                Hibernate.initialize(icmp.getCoffeeGreen().getCoffeeType());
                Hibernate.initialize(icmp.getCoffeeGreen().getCoffeeType().getCoffeeAttribute());
            }
        }
        return alicmr;

    }

    public ArrayList<ProductionCoffee> getProducionCoffeeWithProductionRaportPart(ProductionRaportPart prp) {
        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<ProductionCoffee> alpc = new ArrayList<>();
        String hql = "SELECT DISTINCT productionCoffee FROM ProductionRaportCoffeeAssignment PRCA WHERE PRCA.productionRaportPart = :prp";
        Query q = s.createQuery(hql);
        q.setParameter("prp", prp);
        List result = (List<ProductionCoffee>) q.list();
        alpc.addAll(result);
        for (ProductionCoffee pc : alpc) {
            Hibernate.initialize(pc.getProductType());
        }
        return alpc;
    }

    public InstantCoffeeMixRaport getInstantCoffeeMixRaportWithProductionCoffee(ProductionCoffee pc) {
        if (!s.isOpen()) {
            openSession();
        }
        InstantCoffeeMixRaport icmr = null;
        String hql = "FROM InstantCoffeeMixRaport ICMR WHERE ICMR.productionCoffee= :pc ";
        Query q = s.createQuery(hql).setParameter("pc", pc);
        List result = q.list();
        if (!result.isEmpty()) {
            icmr = (InstantCoffeeMixRaport) result.get(0);
            Hibernate.initialize(icmr);
            Hibernate.initialize(icmr.getInstantCoffeeMixPart());
            for (InstantCoffeeMixPart icmp : icmr.getInstantCoffeeMixPart()) {
                Hibernate.initialize(icmp.getCoffeeGreen().getClass());
                Hibernate.initialize(icmp.getCoffeeGreen().getCoffeeType());
            }
        }
        return icmr;

    }

    public RoastRaport getRoastRaportWithProductionCoffee(ProductionCoffee pc) {

        if (!s.isOpen()) {
            openSession();
        }
        RoastRaport rr = null;
        String hql = "FROM RoastRaport RR WHERE RR.productionCoffee = :pc";
        Query q = s.createQuery(hql).setParameter("pc", pc);
        List result = q.list();
        if (!result.isEmpty()) {
            rr = (RoastRaport) result.get(0);
            Hibernate.initialize(rr);
            Hibernate.initialize(rr.getRoastGreenCoffeePart());
            for (RoastGreenCoffeePart rgcp : rr.getRoastGreenCoffeePart()) {
                Hibernate.initialize(rgcp.getCoffeeGreen());
                Hibernate.initialize(rgcp.getCoffeeGreen().getClass());
                Hibernate.initialize(rgcp.getCoffeeGreen().getCoffeeType());
            }
            Hibernate.initialize(rr.getRoastAromaPart());
            for (RoastAromaPart rap : rr.getRoastAromaPart()) {
                Hibernate.initialize(rap.getAroma());
                Hibernate.initialize(rap.getAroma().getClass());
                Hibernate.initialize(rap.getAroma().getAromaType());
            }
        }
        return rr;
    }

    public ProductionCoffeeExternalReturn getProductionCoffeeExternalReturnWithProductionCoffee(ProductionCoffee pc) {

        if (!s.isOpen()) {
            openSession();
        }
        ProductionCoffeeExternalReturn pcer = null;
        String hql = "FROM ProductionCoffeeExternalReturn PCER WHERE PCER.productionCoffee = :pc";
        Query q = s.createQuery(hql).setParameter("pc", pc);
        List result = q.list();
        if (!result.isEmpty()) {
            pcer = (ProductionCoffeeExternalReturn) result.get(0);
        }
        return pcer;

    }

    public ArrayList<ProductType> getProductType(int productType) {
        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<ProductType> alpt = new ArrayList<>();
        String hql = "FROM ProductType PT WHERE PT.type = :productType AND PT.version = (SELECT MAX(version) FROM ProductType PTT WHERE PTT.productName = PT.productName AND PTT.type = PT.type AND PTT.hidden = 0)";
        Query q = s.createQuery(hql).setParameter("productType", productType);
        List result = (List<ProductType>) q.list();
        alpt.addAll(result);
        return alpt;
    }

    public ProductType getProductTypeWithId(int id) {
        if (!s.isOpen()) {
            openSession();
        }
        String hql = "FROM ProductType PT WHERE PT.id = :productType";
        Query q = s.createQuery(hql).setParameter("productType", id);
        List result = (List<ProductType>) q.list();

        return (ProductType) result.get(0);
    }

    public ArrayList<RoastRaport> getRoastRaportWithEmployee(Employee e) {

        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<RoastRaport> alrr = new ArrayList<>();
        String hql = "FROM RoastRaport RR WHERE RR.completedBy = :e";
        Query q = s.createQuery(hql);
        q.setParameter("e", e);
        List result = (List<RoastRaport>) q.list();
        alrr.addAll(result);
        for (RoastRaport rr : alrr) {
            Hibernate.initialize(rr);
            Hibernate.initialize(rr.getCompletedBy());
            Hibernate.initialize(rr.getProductType());
            Hibernate.initialize(rr.getProductionLine());
            Hibernate.initialize(rr.getProductionCoffee());
            Hibernate.initialize(rr.getProductionCoffee().getProductType());
            if (rr.getRoastAromaPart() != null) {
                Hibernate.initialize(rr.getRoastAromaPart());
                for (RoastAromaPart rap : rr.getRoastAromaPart()) {
                    Hibernate.initialize(rap.getAroma());
                    Hibernate.initialize(rap.getAroma().getAromaType());
                }
            }
            Hibernate.initialize(rr.getRoastGreenCoffeePart());
            for (RoastGreenCoffeePart rgcp : rr.getRoastGreenCoffeePart()) {
                Hibernate.initialize(rgcp.getCoffeeGreen());
                Hibernate.initialize(rgcp.getCoffeeGreen().getCoffeeType());
                Hibernate.initialize(rgcp.getCoffeeGreen().getCoffeeType().getCoffeeAttribute());
            }
            Hibernate.initialize(rr.getRoastPart());

        }

        return alrr;
    }

    public ArrayList<InstantCoffeeMixRaport> getInstantCoffeeMixRaportWithEmployee(Employee e) {

        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<InstantCoffeeMixRaport> alicmr = new ArrayList<>();
        String hql = "FROM InstantCoffeeMixRaport  ICMR WHERE ICMR.mixedBy = :e";
        Query q = s.createQuery(hql).setParameter("e", e);
        List<InstantCoffeeMixRaport> result = (ArrayList<InstantCoffeeMixRaport>) q.list();
        alicmr.addAll(result);
        for (InstantCoffeeMixRaport icmr : alicmr) {
            Hibernate.initialize(icmr.getMixedBy());
            Hibernate.initialize(icmr.getProductType());
            Hibernate.initialize(icmr.getProductionLine());
            //Initialize roast raport
            Hibernate.initialize(icmr.getInstantCoffeeMixPart());
            for (InstantCoffeeMixPart icmp : icmr.getInstantCoffeeMixPart()) {
                Hibernate.initialize(icmp.getCoffeeGreen());
                Hibernate.initialize(icmp.getCoffeeGreen().getCoffeeType());
                Hibernate.initialize(icmp.getCoffeeGreen().getCoffeeType().getCoffeeAttribute());
            }
            Hibernate.initialize(icmr.getProductionLine());
        }
        return alicmr;

    }

    public ArrayList<Object> getResourcesFromDateToDate(Timestamp from, Timestamp to) {

        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<Object> alo = new ArrayList<>();

        String hql = "FROM CoffeeGreen CG WHERE CG.arrivalDate < :to AND CG.arrivalDate >= :from";
        Query q = s.createQuery(hql).setParameter("to", to).setParameter("from", from);
        List<Object> result = (ArrayList<Object>) q.list();
        alo.addAll(result);

        hql = "FROM Aroma A WHERE A.arrivalDate < :to AND A.arrivalDate >= :from";
        q = s.createQuery(hql).setParameter("to", to).setParameter("from", from);
        result = (ArrayList<Object>) q.list();
        alo.addAll(result);

        hql = "FROM ProductionCoffeeExternalReturn PRCA WHERE PRCA.returnDate < :to AND PRCA.returnDate >= :from";
        q = s.createQuery(hql).setParameter("to", to).setParameter("from", from);
        result = (ArrayList<Object>) q.list();
        alo.addAll(result);

        hql = "FROM Sugar PRCA WHERE PRCA.arrivalDate < :to AND PRCA.arrivalDate >= :from";
        q = s.createQuery(hql).setParameter("to", to).setParameter("from", from);
        result = (ArrayList<Object>) q.list();
        alo.addAll(result);

        hql = "FROM DirectPackage PRCA WHERE PRCA.arrivalDate < :to AND PRCA.arrivalDate >= :from";
        q = s.createQuery(hql).setParameter("to", to).setParameter("from", from);
        result = (ArrayList<Object>) q.list();
        alo.addAll(result);

        hql = "FROM ReadyCoffee PRCA WHERE PRCA.arrivalDate < :to AND PRCA.arrivalDate >= :from";
        q = s.createQuery(hql).setParameter("to", to).setParameter("from", from);
        result = (ArrayList<Object>) q.list();
        alo.addAll(result);

        return alo;
    }

    public Object findResourceWithProductionCoffee(Object valueAt) {
        String hql = "FROM ProductionCoffeeExternalReturn PCER WHERE PCER.productionCoffee = :pc";
        Query q = s.createQuery(hql);
        q.setParameter("pc", valueAt);

        List result = (List<ProductionCoffeeExternalReturn>) q.list();

        if (result.size() == 1) {
            return result.get(0);
        }
        hql = "FROM InstantCoffeeMixRaport ICMR WHERE ICMR.productionCoffee = :pc ";
        q = s.createQuery(hql).setParameter("pc", valueAt);
        result = q.list();
        if (result.size() == 1) {
            return result.get(0);
        }

        hql = "FROM RoastRaport RR WHERE RR.productionCoffee = :pc";
        q = s.createQuery(hql);
        q.setParameter("pc", valueAt);
        result = (List<RoastRaport>) q.list();
        if (result.size() == 1) {
            return result.get(0);
        }

        hql = "FROM ReturnedProduct RP WHERE RP.productionCoffee = :pc";
        q = s.createQuery(hql);
        q.setParameter("pc", valueAt);
        result = (List<RoastRaport>) q.list();
        if (result.size() == 1) {
            return result.get(0);
        }
        return null;

    }

    public ArrayList<CoffeeGreen> getCoffeeGreenToStore() {
        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<CoffeeGreen> alcg = new ArrayList<>();
        String hql = "FROM CoffeeGreen C WHERE C.state = :state";
        Query q = s.createQuery(hql);
        q.setParameter("state", Global.COFFEE_GREEN_TO_STORE);
        List result = (List<CoffeeGreen>) q.list();
        alcg.addAll(result);
        return alcg;
    }

    public ArrayList<Aroma> getAromaToStore() {
        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<Aroma> ala = new ArrayList<>();
        String hql = "FROM Aroma A WHERE A.state = :state";
        Query q = s.createQuery(hql);
        q.setParameter("state", Global.TO_STORE);
        List result = (List<Aroma>) q.list();
        ala.addAll(result);
        return ala;
    }

    public ArrayList<ProductionCoffeeExternalReturn> getProductionCoffeeExternalReturnToStore() {
        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<ProductionCoffeeExternalReturn> alpcer = new ArrayList<>();
        String hql = "FROM ProductionCoffeeExternalReturn PCER WHERE PCER.state = :state";
        Query q = s.createQuery(hql);
        q.setParameter("state", Global.PRODUCTION_COFFEE_EXTERNAL_TO_STORE);
        List result = (List<ProductionCoffeeExternalReturn>) q.list();
        alpcer.addAll(result);
        for (ProductionCoffeeExternalReturn pcer : alpcer) {
            Hibernate.initialize(pcer.getProductionRaportPart());
            Hibernate.initialize(pcer.getProductionRaportPart().getProductType());
            Hibernate.initialize(pcer.getLabTest());
            Hibernate.initialize(pcer.getProductionRaportPart().getProductType().getProductName());
        }
        return alpcer;
    }

    public ArrayList<RoastRaport> getRoastRaportWithFromToWithEmployee(Timestamp from, Timestamp to, Employee e) {
        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<RoastRaport> alrr = new ArrayList<>();
        String hql = "FROM RoastRaport RR WHERE RR.completedBy = :e AND RR.completeTime < :to AND RR.completeTime >= :from";
        Query q = s.createQuery(hql);
        q.setParameter("e", e).setParameter("to", to).setParameter("from", from);
        List result = (List<RoastRaport>) q.list();
        alrr.addAll(result);
        return alrr;
    }

    public ArrayList<RoastRaport> getRoastRaportWithFromTo(Timestamp from, Timestamp to) {
        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<RoastRaport> alrr = new ArrayList<>();
        String hql = "FROM RoastRaport RR WHERE RR.completeTime < :to AND RR.completeTime >= :from";
        Query q = s.createQuery(hql);
        q.setParameter("to", to).setParameter("from", from);
        List result = (List<RoastRaport>) q.list();
        alrr.addAll(result);
        return alrr;
    }

    public Iterable<InstantCoffeeMixRaport> getInstantCoffeeMixRaportWithFromToEmployee(Timestamp from, Timestamp to, Employee e) {
        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<InstantCoffeeMixRaport> alrr = new ArrayList<>();
        String hql = "FROM InstantCoffeeMixRaport ICMR WHERE ICMR.mixedBy = :e AND ICMR.mixDate < :to AND ICMR.mixDate >= :from";
        Query q = s.createQuery(hql);
        q.setParameter("e", e).setParameter("to", to).setParameter("from", from);
        List result = (List<RoastRaport>) q.list();
        alrr.addAll(result);
        return alrr;
    }

    public Iterable<InstantCoffeeMixRaport> getInstantCoffeeMixRaportWithFromTo(Timestamp from, Timestamp to) {
        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<InstantCoffeeMixRaport> alrr = new ArrayList<>();
        String hql = "FROM InstantCoffeeMixRaport ICMR WHERE ICMR.mixDate < :to AND ICMR.mixDate >= :from";
        Query q = s.createQuery(hql);
        q.setParameter("to", to).setParameter("from", from);
        List result = (List<RoastRaport>) q.list();
        alrr.addAll(result);
        return alrr;
    }

    public ArrayList<SugarType> getSugarType() {
        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<SugarType> alst = new ArrayList<>();
        String hql = "FROM SugarType";
        Query q = s.createQuery(hql);
        List result = (List<SugarType>) q.list();
        alst.addAll(result);
        return alst;
    }

    public String getMaxLabIdSugar() {
        if (!s.isOpen()) {
            openSession();
        }
        String hql = "SELECT S FROM Sugar S WHERE S.labId = (SELECT MAX(labId) From Sugar)";
        Query q = s.createQuery(hql);
        List<Sugar> result = (List<Sugar>) q.list();
        if (result.isEmpty()) {
            return null;
        }
        Sugar su = result.get(0);
        System.out.println(su.getLabId());
        return su.getLabId();
    }

    public String getMaxLabIdCardboard() {
        if (!s.isOpen()) {
            openSession();
        }
        String hql = "SELECT C FROM Cardboard C WHERE C.labId = (SELECT MAX(labId) From Cardboard)";
        Query q = s.createQuery(hql);
        List<Cardboard> result = (List<Cardboard>) q.list();
        if (result.isEmpty()) {
            return null;
        }
        Cardboard c = result.get(0);
        System.out.println(c.getLabId());
        return c.getLabId();

    }

    public ArrayList<CardboardType> getCardboardType() {
        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<CardboardType> alct = new ArrayList<>();
        String hql = "FROM CardboardType";
        Query q = s.createQuery(hql);
        List result = (List<CardboardType>) q.list();
        alct.addAll(result);
        return alct;

    }

    public String getMaxLabIdReadyCoffee() {
        if (!s.isOpen()) {
            openSession();
        }
        String hql = "SELECT RC FROM ReadyCoffee RC WHERE RC.labId = (SELECT MAX(labId) From ReadyCoffee)";
        Query q = s.createQuery(hql);
        List<ReadyCoffee> result = (List<ReadyCoffee>) q.list();
        if (result.isEmpty()) {
            return null;
        }
        ReadyCoffee c = result.get(0);
        System.out.println(c.getLabId());
        return c.getLabId();
    }

    public ArrayList<DirectPackageType> getDirectPackageType() {
        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<DirectPackageType> aldpt = new ArrayList<>();
        String hql = "FROM DirectPackageType";
        Query q = s.createQuery(hql);
        List result = (List<DirectPackageType>) q.list();
        aldpt.addAll(result);
        return aldpt;
    }

    public String getMaxLabIdDirectPackage() {
        if (!s.isOpen()) {
            openSession();
        }
        String hql = "SELECT DP FROM DirectPackage DP WHERE DP.labId = (SELECT MAX(labId) From DirectPackage)";
        Query q = s.createQuery(hql);
        List<DirectPackage> result = (List<DirectPackage>) q.list();
        if (result.isEmpty()) {
            return null;
        }
        DirectPackage c = result.get(0);
        System.out.println(c.getLabId());
        return c.getLabId();
    }

    public ArrayList<Cardboard> getCardboardToExamine() {
        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<Cardboard> ala = new ArrayList<>();
        String hql = "FROM Cardboard A WHERE A.state = :state";
        Query q = s.createQuery(hql);
        q.setParameter("state", Global.TO_EXAMINE);
        List result = (List<Cardboard>) q.list();
        ala.addAll(result);
        return ala;
    }

    public ArrayList<ReadyCoffee> getReadyCoffeeToExamine() {
        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<ReadyCoffee> ala = new ArrayList<>();
        String hql = "FROM ReadyCoffee A WHERE A.state = :state";
        Query q = s.createQuery(hql);
        q.setParameter("state", Global.TO_EXAMINE);
        List result = (List<ReadyCoffee>) q.list();
        ala.addAll(result);
        return ala;
    }

    public ArrayList<DirectPackage> getDirectPackageToExamine() {
        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<DirectPackage> ala = new ArrayList<>();
        String hql = "FROM DirectPackage A WHERE A.state = :state";
        Query q = s.createQuery(hql);
        q.setParameter("state", Global.TO_EXAMINE);
        List result = (List<DirectPackage>) q.list();
        ala.addAll(result);
        return ala;
    }

    public ArrayList<Sugar> getSugarToExamine() {
        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<Sugar> ala = new ArrayList<>();
        String hql = "FROM Sugar A WHERE A.state = :state";
        Query q = s.createQuery(hql);
        q.setParameter("state", Global.TO_EXAMINE);
        List result = (List<Sugar>) q.list();
        ala.addAll(result);
        return ala;
    }

    public ArrayList<Cardboard> getCardboardToStore() {
        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<Cardboard> ala = new ArrayList<>();
        String hql = "FROM Cardboard A WHERE A.state = :state";
        Query q = s.createQuery(hql);
        q.setParameter("state", Global.TO_STORE);
        List result = (List<Cardboard>) q.list();
        ala.addAll(result);
        return ala;
    }

    public ArrayList<ReadyCoffee> getReadyCoffeeToStore() {
        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<ReadyCoffee> ala = new ArrayList<>();
        String hql = "FROM ReadyCoffee A WHERE A.state = :state";
        Query q = s.createQuery(hql);
        q.setParameter("state", Global.TO_STORE);
        List result = (List<ReadyCoffee>) q.list();
        ala.addAll(result);
        return ala;
    }

    public ArrayList<DirectPackage> getDirectPackageToStore() {
        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<DirectPackage> ala = new ArrayList<>();
        String hql = "FROM DirectPackage A WHERE A.state = :state";
        Query q = s.createQuery(hql);
        q.setParameter("state", Global.TO_STORE);
        List result = (List<DirectPackage>) q.list();
        ala.addAll(result);
        return ala;
    }

    public ArrayList<Sugar> getSugarToStore() {
        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<Sugar> ala = new ArrayList<>();
        String hql = "FROM Sugar A WHERE A.state = :state";
        Query q = s.createQuery(hql);
        q.setParameter("state", Global.TO_STORE);
        List result = (List<Sugar>) q.list();
        ala.addAll(result);
        return ala;
    }

    public Details findWithLabId(String text) {

        Object o;

        String hql = "FROM CoffeeGreen O WHERE O.labId = :id";
        Query q = s.createQuery(hql).setParameter("id", text);
        List result = q.list();
        if (result.size() > 0) {
            return (Details) result.get(0);
        }

        hql = "FROM Aroma O WHERE O.labId = :id";
        q = s.createQuery(hql).setParameter("id", text);
        result = q.list();
        if (result.size() > 0) {
            return (Details) result.get(0);
        }

        hql = "FROM ProductionCoffeeExternalReturn O WHERE O.labId = :id";
        q = s.createQuery(hql).setParameter("id", text);
        result = q.list();
        if (result.size() > 0) {
            return (Details) result.get(0);
        }
        hql = "FROM Sugar O WHERE O.labId = :id";
        q = s.createQuery(hql).setParameter("id", text);
        result = q.list();
        if (result.size() > 0) {
            return (Details) result.get(0);
        }

        hql = "FROM DirectPackage O WHERE O.labId = :id";
        q = s.createQuery(hql).setParameter("id", text);
        result = q.list();
        if (result.size() > 0) {
            return (Details) result.get(0);
        }

        hql = "FROM Cardboard O WHERE O.labId = :id";
        q = s.createQuery(hql).setParameter("id", text);
        result = q.list();
        if (result.size() > 0) {
            return (Details) result.get(0);
        }

        hql = "FROM ReadyCoffee O WHERE O.labId = :id";
        q = s.createQuery(hql).setParameter("id", text);
        result = q.list();
        if (result.size() > 0) {
            return (Details) result.get(0);
        }

        return null;
    }

    public ReadyCoffee getReadyCoffeeWithProductionCoffee(ProductionCoffee pc) {
        if (!s.isOpen()) {
            openSession();
        }
        ReadyCoffee pcer = null;
        String hql = "FROM ReadyCoffee PCER WHERE PCER.productionCoffee = :pc";
        Query q = s.createQuery(hql).setParameter("pc", pc);
        List result = q.list();
        if (!result.isEmpty()) {
            pcer = (ReadyCoffee) result.get(0);
        }
        return pcer;
    }

    public ArrayList<ProductionRaportPart> getProductionRaportPartWithFromTo(Timestamp from, Timestamp to) {
        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<ProductionRaportPart> alrr = new ArrayList<>();
        String hql = "FROM ProductionRaportPart PRP WHERE PRP.raportDate < :to AND PRP.raportDate >= :from AND PRP.labTestState >= 0";
        Query q = s.createQuery(hql);
        q.setParameter("to", to).setParameter("from", from);
        List result = (List<ProductionRaportPart>) q.list();
        alrr.addAll(result);
        return alrr;
    }

    public ArrayList<ProductionRaportPart> getProductionRaportPartWithFromToAndProductionLine(Timestamp from, Timestamp to, ProductionLine prodLine) {
        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<ProductionRaportPart> alrr = new ArrayList<>();
        String hql = "FROM ProductionRaportPart PRP WHERE PRP.raportDate < :to AND PRP.raportDate >= :from AND PRP.productionLine = :prodLine  ORDER BY PRP.raportDate";
        Query q = s.createQuery(hql);
        q.setParameter("to", to).setParameter("from", from).setParameter("prodLine", prodLine);
        List result = (List<ProductionRaportPart>) q.list();
        alrr.addAll(result);
        return alrr;
    }

    public int setProductTypeState(ProductType pt, boolean b) {
        if (!s.isOpen()) {
            openSession();
        }
        s.beginTransaction();
        String hql = "UPDATE ProductType SET hidden = :state WHERE productName = :name AND type = :type";
        Query q = s.createQuery(hql);
        q.setParameter("name", pt.getProductName()).setParameter("type", pt.getType()).setParameter("state", b);
        int result = q.executeUpdate();
        s.getTransaction().commit();
        return result;
    }

    public ArrayList<DirectPackage> getDirectPackageWithDirectPackageType(DirectPackageType selectedDirectPackageType) {
        ArrayList<DirectPackage> aldp = new ArrayList<>();
        String hql = "FROM DirectPackage DP WHERE DP.directPackageType = :directPackageType AND DP.state = :state";
        Query q = s.createQuery(hql);
        q.setParameter("directPackageType", selectedDirectPackageType);
        q.setParameter("state", Global.READY_TO_USE);
        List result = (List<DirectPackage>) q.list();
        aldp.addAll(result);
        return aldp;
    }

    public ArrayList<DirectPackage> getDirectPackageWithDirectPackageTypeNoState(DirectPackageType selectedDirectPackageType) {
        ArrayList<DirectPackage> aldp = new ArrayList<>();
        String hql = "FROM DirectPackage DP WHERE DP.directPackageType = :directPackageType AND DP.state = :state";
        Query q = s.createQuery(hql);
        q.setParameter("directPackageType", selectedDirectPackageType);
        q.setParameter("state", Global.READY_TO_USE);
        List result = (List<DirectPackage>) q.list();
        aldp.addAll(result);
        return aldp;
    }

    public ArrayList<Cardboard> getCardboardWithCardboardType(CardboardType selectedCardboardType) {
        ArrayList<Cardboard> aldp = new ArrayList<>();
        String hql = "FROM Cardboard C WHERE C.cardboardType = :cardboardType AND C.state = :state";
        Query q = s.createQuery(hql);
        q.setParameter("cardboardType", selectedCardboardType);
        q.setParameter("state", Global.READY_TO_USE);
        List result = (List<Cardboard>) q.list();
        aldp.addAll(result);
        return aldp;
    }

    public DirectPackage findDirectPackageWithLabId(String string) {
        if (!s.isOpen()) {
            openSession();
        }
        DirectPackage cg;

        String hql = "FROM DirectPackage C WHERE C.labId = :valueAt";
        Query q = s.createQuery(hql);
        q.setParameter("valueAt", string);
        List result = (List<DirectPackage>) q.list();
        if (result.isEmpty()) {
            return null;
        }
        cg = (DirectPackage) result.get(0);
        return cg;
    }

    public Cardboard findCardboardWithLabId(String string) {
        if (!s.isOpen()) {
            openSession();
        }
        Cardboard cg;

        String hql = "FROM Cardboard C WHERE C.labId = :valueAt";
        Query q = s.createQuery(hql);
        q.setParameter("valueAt", string);
        List result = (List<Cardboard>) q.list();
        if (result.isEmpty()) {
            return null;
        }
        cg = (Cardboard) result.get(0);
        return cg;
    }

    public ArrayList<RoastRaport> getRoastRaportWithFromToAndProductionLine(Timestamp from, Timestamp to, ProductionLine productionLine) {
        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<RoastRaport> alrr = new ArrayList<>();
        String hql = "FROM RoastRaport RR WHERE RR.completeTime < :to AND RR.completeTime >= :from AND RR.productionLine = :prodLine ORDER BY RR.completeTime";
        Query q = s.createQuery(hql);
        q.setParameter("to", to).setParameter("from", from).setParameter("prodLine", productionLine);
        List result = (List<ProductionRaportPart>) q.list();
        alrr.addAll(result);
        return alrr;
    }

    public ArrayList<InstantCoffeeMixRaport> getInstantCoffeeMixRaportWithFromToEmployee(Timestamp from, Timestamp to) {
        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<InstantCoffeeMixRaport> alicmr = new ArrayList<>();
        String hql = "FROM InstantCoffeeMixRaport ICMR WHERE ICMR.mixDate < :to AND ICMR.mixDate >= :from ORDER BY ICMR.mixDate";
        Query q = s.createQuery(hql);
        q.setParameter("to", to).setParameter("from", from);
        List result = (List<ProductionRaportPart>) q.list();
        alicmr.addAll(result);
        return alicmr;
    }

    public ArrayList<ProductionCoffeeReturn> getProductionCoffeeReturnWithProductionCoffee(ProductionCoffee productionCoffee) {
        if (!s.isOpen()) {
            openSession();
        }
        ArrayList<ProductionCoffeeReturn> alpcr = new ArrayList<>();
        String hql = "FROM ProductionCoffeeReturn PCR WHERE PCR.productionCoffee = :pc";
        Query q = s.createQuery(hql);
        q.setParameter("pc", productionCoffee);
        List result = (List<ProductionRaportPart>) q.list();
        alpcr.addAll(result);
        return alpcr;

    }

    public boolean tryLatestProductionRaportPart(String batch) {

        if (!s.isOpen()) {
            openSession();
        }
        String hql = "FROM ProductionRaportPart PRP WHERE PRP.batchInfo = :batch";
        Query q = s.createQuery(hql);
        q.setParameter("batch", batch);
        List result = (List<ProductionRaportPart>) q.list();
        return result.size() > 0;
    }

    public ArrayList<Employee> getOperators() {
        if (!s.isOpen()) {
            openSession();
        }
        String hql = "FROM Employee E WHERE E.jobPosition = :pos";
        Query q = s.createQuery(hql);
        q.setParameter("pos", Global.OPERATOR);
        return (ArrayList<Employee>) q.list();
    }

    public ArrayList<ProductionOrder> getProductionOrders(ProductionLine productionLine) {

        if (!s.isOpen()) {
            openSession();
        }
        String hql = "FROM ProductionOrder PO WHERE (PO.state <= :state1) AND PO.productionLine = :productionLine";
        Query q = s.createQuery(hql);
        q.setParameter("state1", ProductionOrder.PRODUCTION_ORDER_PAUSED);
        q.setParameter("productionLine", productionLine);

        return (ArrayList<ProductionOrder>) q.list();

    }

    public int getLatestProductionOrderPosition(ProductionLine selectedProductionLine) {
        int toReturn = 0;
        if (!s.isOpen()) {
            openSession();
        }
        String hql = "SELECT MAX(positionInQueue) FROM ProductionOrder PO WHERE PO.productionLine = :productionLine AND PO.state < 3";
        Query q = s.createQuery(hql);
        q.setParameter("productionLine", selectedProductionLine);
        List result = q.list();
        if (result.get(0) != null) {
            Integer i = (Integer) result.get(0);
            toReturn = i + 1;
        }
        return toReturn;
    }

    public ArrayList<ProductionRaportPart> getProductsToFinish() {
        ArrayList<ProductionRaportPart> alprp = new ArrayList<>();
        String hql = "FROM ProductionRaportPart PRP WHERE PRP.labTestState > 0";
        Query q = s.createQuery(hql);
        List result = (List<ProductionRaportPart>) q.list();
        alprp.addAll(result);
        for (ProductionRaportPart prp : alprp) {
            Hibernate.initialize(prp.getProductType());
            Hibernate.initialize(prp.getProductionRaportCoffeeAssignment());
            for (ProductionRaportCoffeeAssignment prca : prp.getProductionRaportCoffeeAssignment()) {
                Hibernate.initialize(prca);
                Hibernate.initialize(prca.getProductionCoffee());
                Hibernate.initialize(prca.getProductionRaportPart());
            }
        }
        return alprp;
    }

    public ArrayList<ProductionOrder> getProductionOrdersHistory(ProductionLine productionLine) {
        if (!s.isOpen()) {
            openSession();
        }
        String hql = "FROM ProductionOrder PO WHERE PO.state = :state1 AND PO.productionLine = :productionLine";
        Query q = s.createQuery(hql);
        q.setParameter("state1", ProductionOrder.PRODUCTION_ORDER_COMPLETED);
        q.setParameter("productionLine", productionLine);
        return (ArrayList<ProductionOrder>) q.list();
    }

    public DirectPackage getDirectPackageWithLabId(String labId) {
        if (!s.isOpen()) {
            openSession();
        }
        DirectPackage cg;
        String hql = "FROM DirectPackage DP WHERE DP.labId = :labId";
        Query q = s.createQuery(hql);
        q.setParameter("labId", labId);
        List result = (List<CoffeeGreen>) q.list();
        if (result.isEmpty()) {
            return null;
        }
        cg = (DirectPackage) result.get(0);
        Hibernate.initialize(cg.getDirectPackageType());
        Hibernate.initialize(cg.getStoreman());
        return cg;
    }

    public ArrayList<ProductionOrder> getProductionOrdersHistoryFromTo(ProductionLine productionLine, Timestamp from, Timestamp to) {
        if (!s.isOpen()) {
            openSession();
        }
        String hql = "FROM ProductionOrder PO WHERE PO.state = :state1 AND PO.productionLine = :productionLine AND PO.orderTime < :to AND PO.orderTime > :from";
        Query q = s.createQuery(hql);
        q.setParameter("state1", ProductionOrder.PRODUCTION_ORDER_COMPLETED);
        q.setParameter("productionLine", productionLine);
        q.setParameter("from", from);
        q.setParameter("to", to);
        return (ArrayList<ProductionOrder>) q.list();
    }

    public ReturnedProduct getReturnedProduct(ProductionRaportPart selected) {
        if (!s.isOpen()) {
            openSession();
        }
        ReturnedProduct rp;
        String hql = "FROM ReturnedProduct RP WHERE RP.productionRaportPart = :productionRaportPart";
        Query q = s.createQuery(hql);
        q.setParameter("productionRaportPart", selected);
        List<ReturnedProduct> result = (List<ReturnedProduct>) q.list();
        if (result.isEmpty()) {
            return null;
        } else {
            rp = result.get(0);
        }
        Hibernate.initialize(rp.getProductionCoffee());
        return rp;

    }

}
