package UNIS.Dao;

import UNIS.Model.data;

import java.io.*;

import java.net.URL;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import java.util.List;

import java.util.ArrayList;

import com.google.gson.*;

import javax.faces.context.ExternalContext;

public class metodos {
    public metodos() {
        super();
    }


    public void insertUNIS(data Person) throws Exception {
        String baseUrl =
            "https://dbdesarrollounis-a523158.db.us2.oraclecloudapps.com/apex/HistoricosHCM/HISTORICOS";
        SSLContext ctx = SSLContext.getInstance("TLS");
        ctx.init(new KeyManager[0],
                 new TrustManager[] { new DefaultTrustManager() },
                 new SecureRandom());
        SSLContext.setDefault(ctx);

        URL url =
            new URL(null, baseUrl, new sun.net.www.protocol.https.Handler());
        HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("User-Agent", "PostmanRuntime/7.24.1");
        conn.addRequestProperty("PersonNumber",
                                "" + Person.getPersonNumber().toString() + "");
        conn.addRequestProperty("EffectiveStartDate",
                                "" + Person.getEffectiveStartDate() + "");
        conn.addRequestProperty("LastName", "" + Person.getLastName() + "");
        conn.addRequestProperty("PreviousLastName",
                                "" + Person.getPreviousLastName() + "");
        conn.addRequestProperty("FirstName", "" + Person.getFirstName() + "");
        conn.addRequestProperty("MiddleNames",
                                "" + Person.getMiddleNames() + "");
        conn.addRequestProperty("NameInformation1",
                                "" + Person.getNameInformation1() + "");
        conn.addRequestProperty("NationalIdentifierType",
                                "" + Person.getNationalIdentifierType() + "");
        conn.addRequestProperty("NationalIdentifierNumber",
                                "" + Person.getNationalIdentifierNumber() +
                                "");
        conn.addRequestProperty("DateOfBirth",
                                "" + Person.getDateOfBirth() + "");
        conn.addRequestProperty("MaritalStatus",
                                "" + Person.getMaritalStatus() + "");
        conn.addRequestProperty("Sex", "" + Person.getSex() + "");
        conn.addRequestProperty("Ethnicity", "" + Person.getEthnicity() + "");
        conn.addRequestProperty("Religion", "" + Person.getReligion() + "");
        conn.addRequestProperty("BloodType", "" + Person.getBloodType() + "");
        conn.addRequestProperty("TownOfBirth",
                                "" + Person.getTownOfBirth() + "");
        conn.addRequestProperty("CountryOfBirth",
                                "" + Person.getCountryOfBirth() + "");
        conn.addRequestProperty("RegionOfBirth",
                                "" + Person.getRegionOfBirth() + "");
        conn.addRequestProperty("LegislationCode",
                                "" + Person.getLegislationCode() + "");
        conn.addRequestProperty("HighestEducationLevel",
                                "" + Person.getHighestEducationLevel() + "");
        conn.addRequestProperty("AddressLine1",
                                "" + Person.getAddressLine1() + "");
        conn.addRequestProperty("AddlAddressAttribute3",
                                "" + Person.getAddlAddressAttribute3() + "");
        conn.addRequestProperty("PostalCode", "" + Person.getPostalCode());
        conn.addRequestProperty("TownOrCity",
                                "" + Person.getTownOrCity() + "");
        conn.addRequestProperty("Country", "" + Person.getCountry() + "");
        conn.addRequestProperty("AddressType",
                                "" + Person.getAddressType() + "");
        conn.addRequestProperty("EmailAddress",
                                "" + Person.getEmailAddress() + "");
        conn.addRequestProperty("EmailType", "" + Person.getEmailType() + "");
        conn.addRequestProperty("PhoneNumber",
                                "" + Person.getPhoneNumber() + "");
        conn.addRequestProperty("PhoneType", "" + Person.getPhoneType() + "");
        conn.addRequestProperty("WorkerType",
                                "" + Person.getWorkerType() + "");
        conn.addRequestProperty("ActionCode",
                                "" + Person.getActionCode() + "");
        conn.addRequestProperty("EffectiveEndDate",
                                "" + Person.getEffectiveEndDate() + "");
        conn.addRequestProperty("AssignmentCategory",
                                "" + Person.getAssignmentCategory() + "");
        conn.addRequestProperty("WorkerCategory",
                                "" + Person.getWorkerCategory() + "");
        conn.addRequestProperty("HourlySalariedCode",
                                "" + Person.getHourlySalariedCode() + "");
        conn.addRequestProperty("GradeCode", "" + Person.getGradeCode() + "");
        conn.addRequestProperty("PositionCode",
                                "" + Person.getPositionCode() + "");
        conn.addRequestProperty("JobCode", "" + Person.getJobCode() + "");
        conn.addRequestProperty("LocationCode",
                                "" + Person.getLocationCode() + "");
        conn.addRequestProperty("DepartmentName",
                                "" + Person.getDepartmentName() + "");
        conn.addRequestProperty("Frequency", "" + Person.getFrequency() + "");
        conn.addRequestProperty("NormalHours",
                                "" + Person.getNormalHours() + "");
        conn.addRequestProperty("FullPartTime",
                                "" + Person.getFullPartTime() + "");
        conn.addRequestProperty("PersonTypeCode",
                                "" + Person.getPersonTypeCode() + "");
        conn.addRequestProperty("BankName", "" + Person.getBankName() + "");
        conn.addRequestProperty("AccountNumber",
                                "" + Person.getAccountNumber() + "");
        conn.addRequestProperty("SalaryAmount",
                                "" + Person.getSalaryAmount().toString() + "");
        conn.addRequestProperty("ExternalIdentifierNumber",
                                "" + Person.getExternalIdentifierNumber());
        conn.addRequestProperty("ExternalIdentifierType",
                                "" + Person.getExternalIdentifierType());
        conn.setHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String arg0, SSLSession arg1) {
                    return true;
                }
            });

        System.out.println(conn.getResponseCode());
        if (conn.getResponseCode() == 200) {
            FacesMessage msg =
                new FacesMessage(FacesMessage.SEVERITY_INFO, null,
                                 "Exito al Ingresr Registros");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            //FacesContext fctx = FacesContext.getCurrentInstance();
            //ExternalContext ectx = fctx.getExternalContext();
            //ectx.redirect("/HistoricoUNIS-ViewController-context-root/faces/index");
        } else {
            FacesMessage msg =
                new FacesMessage(FacesMessage.SEVERITY_INFO, null,
                                 "Error al Ingresr Registros");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        conn.disconnect();
    }

    public void updateUNIS(data Person) throws Exception {
        String baseUrl =
            "https://dbdesarrollounis-a523158.db.us2.oraclecloudapps.com/apex/HistoricosHCM/HISTORICOS";
        SSLContext ctx = SSLContext.getInstance("TLS");
        ctx.init(new KeyManager[0],
                 new TrustManager[] { new DefaultTrustManager() },
                 new SecureRandom());
        SSLContext.setDefault(ctx);

        URL url =
            new URL(null, baseUrl, new sun.net.www.protocol.https.Handler());
        HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
        conn.setRequestMethod("PUT");
        conn.setRequestProperty("User-Agent", "PostmanRuntime/7.24.1");
        conn.addRequestProperty("PersonNumber",
                                "" + Person.getPersonNumber().toString() + "");
        conn.addRequestProperty("EffectiveStartDate",
                                "" + Person.getEffectiveStartDate() + "");
        conn.addRequestProperty("LastName", "" + Person.getLastName() + "");
        conn.addRequestProperty("PreviousLastName",
                                "" + Person.getPreviousLastName() + "");
        conn.addRequestProperty("FirstName", "" + Person.getFirstName() + "");
        conn.addRequestProperty("MiddleNames",
                                "" + Person.getMiddleNames() + "");
        conn.addRequestProperty("NameInformation1",
                                "" + Person.getNameInformation1() + "");
        conn.addRequestProperty("NationalIdentifierType",
                                "" + Person.getNationalIdentifierType() + "");
        conn.addRequestProperty("NationalIdentifierNumber",
                                "" + Person.getNationalIdentifierNumber() +
                                "");
        conn.addRequestProperty("DateOfBirth",
                                "" + Person.getDateOfBirth() + "");
        conn.addRequestProperty("MaritalStatus",
                                "" + Person.getMaritalStatus() + "");
        conn.addRequestProperty("Sex", "" + Person.getSex() + "");
        conn.addRequestProperty("Ethnicity", "" + Person.getEthnicity() + "");
        conn.addRequestProperty("Religion", "" + Person.getReligion() + "");
        conn.addRequestProperty("BloodType", "" + Person.getBloodType() + "");
        conn.addRequestProperty("TownOfBirth",
                                "" + Person.getTownOfBirth() + "");
        conn.addRequestProperty("CountryOfBirth",
                                "" + Person.getCountryOfBirth() + "");
        conn.addRequestProperty("RegionOfBirth",
                                "" + Person.getRegionOfBirth() + "");
        conn.addRequestProperty("LegislationCode",
                                "" + Person.getLegislationCode() + "");
        conn.addRequestProperty("HighestEducationLevel",
                                "" + Person.getHighestEducationLevel() + "");
        conn.addRequestProperty("AddressLine1",
                                "" + Person.getAddressLine1() + "");
        conn.addRequestProperty("AddlAddressAttribute3",
                                "" + Person.getAddlAddressAttribute3() + "");
        conn.addRequestProperty("PostalCode", "" + Person.getPostalCode());
        conn.addRequestProperty("TownOrCity",
                                "" + Person.getTownOrCity() + "");
        conn.addRequestProperty("Country", "" + Person.getCountry() + "");
        conn.addRequestProperty("AddressType",
                                "" + Person.getAddressType() + "");
        conn.addRequestProperty("EmailAddress",
                                "" + Person.getEmailAddress() + "");
        conn.addRequestProperty("EmailType", "" + Person.getEmailType() + "");
        conn.addRequestProperty("PhoneNumber",
                                "" + Person.getPhoneNumber() + "");
        conn.addRequestProperty("PhoneType", "" + Person.getPhoneType() + "");
        conn.addRequestProperty("WorkerType",
                                "" + Person.getWorkerType() + "");
        conn.addRequestProperty("ActionCode",
                                "" + Person.getActionCode() + "");
        conn.addRequestProperty("EffectiveEndDate",
                                "" + Person.getEffectiveEndDate() + "");
        conn.addRequestProperty("AssignmentCategory",
                                "" + Person.getAssignmentCategory() + "");
        conn.addRequestProperty("WorkerCategory",
                                "" + Person.getWorkerCategory() + "");
        conn.addRequestProperty("HourlySalariedCode",
                                "" + Person.getHourlySalariedCode() + "");
        conn.addRequestProperty("GradeCode", "" + Person.getGradeCode() + "");
        conn.addRequestProperty("PositionCode",
                                "" + Person.getPositionCode() + "");
        conn.addRequestProperty("JobCode", "" + Person.getJobCode() + "");
        conn.addRequestProperty("LocationCode",
                                "" + Person.getLocationCode() + "");
        conn.addRequestProperty("DepartmentName",
                                "" + Person.getDepartmentName() + "");
        conn.addRequestProperty("Frequency", "" + Person.getFrequency() + "");
        conn.addRequestProperty("NormalHours",
                                "" + Person.getNormalHours() + "");
        conn.addRequestProperty("FullPartTime",
                                "" + Person.getFullPartTime() + "");
        conn.addRequestProperty("PersonTypeCode",
                                "" + Person.getPersonTypeCode() + "");
        conn.addRequestProperty("BankName", "" + Person.getBankName() + "");
        conn.addRequestProperty("AccountNumber",
                                "" + Person.getAccountNumber() + "");
        conn.addRequestProperty("SalaryAmount",
                                "" + Person.getSalaryAmount().toString() + "");
        conn.addRequestProperty("ExternalIdentifierNumber",
                                "" + Person.getExternalIdentifierNumber());
        conn.addRequestProperty("ExternalIdentifierType",
                                "" + Person.getExternalIdentifierType());
        conn.setHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String arg0, SSLSession arg1) {
                    return true;
                }
            });

        System.out.println(conn.getResponseCode());
        if (conn.getResponseCode() == 200) {
            FacesMessage msg =
                new FacesMessage(FacesMessage.SEVERITY_INFO, null,
                                 "Exito al Actualizar Registros");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            FacesMessage msg =
                new FacesMessage(FacesMessage.SEVERITY_INFO, null,
                                 "Error al Actualizar Registros");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }


        conn.disconnect();
    }

    public void deleteUNIS(data Person) throws Exception {
        String baseUrl =
            "https://dbdesarrollounis-a523158.db.us2.oraclecloudapps.com/apex/HistoricosHCM/HISTORICOS";
        SSLContext ctx = SSLContext.getInstance("TLS");
        ctx.init(new KeyManager[0],
                 new TrustManager[] { new DefaultTrustManager() },
                 new SecureRandom());
        SSLContext.setDefault(ctx);

        URL url =
            new URL(null, baseUrl, new sun.net.www.protocol.https.Handler());
        HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
        conn.setRequestMethod("DELETE");
        conn.setRequestProperty("User-Agent", "PostmanRuntime/7.24.1");
        conn.addRequestProperty("PersonNumber",
                                "" + Person.getPersonNumber() + "");
        conn.setHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String arg0, SSLSession arg1) {
                    return true;
                }
            });

        System.out.println(conn.getResponseCode());
        if (conn.getResponseCode() == 200) {
            FacesMessage msg =
                new FacesMessage(FacesMessage.SEVERITY_INFO, null,
                                 "Registro Eliminado");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            //
            //FacesContext fctx = FacesContext.getCurrentInstance();
            //ExternalContext ectx = fctx.getExternalContext();
            //ectx.redirect("/HistoricoUNIS-ViewController-context-root/faces/index");
        } else {
            FacesMessage msg =
                new FacesMessage(FacesMessage.SEVERITY_INFO, null,
                                 "Error no se pudo Eliminar");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        conn.disconnect();
    }

    public List<data> listaUNIS() throws Exception {
        String baseUrl =
            "https://dbdesarrollounis-a523158.db.us2.oraclecloudapps.com/apex/HistoricosHCM/HISTORICOS";
        SSLContext ctx = SSLContext.getInstance("TLS");
        ctx.init(new KeyManager[0],
                 new TrustManager[] { new DefaultTrustManager() },
                 new SecureRandom());
        SSLContext.setDefault(ctx);

        URL url =
            new URL(null, baseUrl, new sun.net.www.protocol.https.Handler());
        HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestProperty("User-Agent", "PostmanRuntime/7.24.1");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String arg0, SSLSession arg1) {
                    return true;
                }
            });
        BufferedReader in =
            new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String response = in.readLine();
        JsonParser jsonParser = new JsonParser();
        JsonObject json = (JsonObject)jsonParser.parse(response);
        List<data> lts = new ArrayList();
        data person;
        JsonObject item;
        for (JsonElement itemElement : json.get("items").getAsJsonArray()) {
            person = new data();
            item = itemElement.getAsJsonObject();
            if (item.has("personnumber")) {
                person.setPersonNumber(item.get("personnumber").getAsInt());
            }
            if (item.has("effectivestartdate")) {
                person.setEffectiveStartDate(item.get("effectivestartdate").getAsString());
            }
            if (item.has("lastname")) {
                person.setLastName(item.get("lastname").getAsString());
            }
            if (item.has("previouslastname")) {
                person.setPreviousLastName(item.get("lastname").getAsString());
            }
            if (item.has("firstname")) {
                person.setFirstName(item.get("firstname").getAsString());
            }
            if (item.has("middlenames")) {
                person.setMiddleNames(item.get("middlenames").getAsString());
            }
            if (item.has("nameinformation1")) {
                person.setNameInformation1(item.get("nameinformation1").getAsString());
            }
            if (item.has("nationalidentifiertype")) {
                person.setNationalIdentifierType(item.get("nationalidentifiertype").getAsString());
            }
            if (item.has("nationalidentifiernumber")) {
                person.setNationalIdentifierNumber(item.get("nationalidentifiernumber").getAsString());
            }
            if (item.has("dateofbirth")) {
                person.setDateOfBirth(item.get("dateofbirth").getAsString());
            }
            if (item.has("maritalstatus")) {
                person.setMaritalStatus(item.get("maritalstatus").getAsString());
            }
            if (item.has("sex")) {
                person.setSex(item.get("sex").getAsString());
            }
            if (item.has("ethnicity")) {
                person.setEthnicity(item.get("ethnicity").getAsString());
            }
            if (item.has("religion")) {
                person.setReligion(item.get("religion").getAsString());
            }
            if (item.has("bloodtype")) {
                person.setBloodType(item.get("bloodtype").getAsString());
            }
            if (item.has("townofbirth")) {
                person.setTownOfBirth(item.get("townofbirth").getAsString());
            }
            if (item.has("countryofbirth")) {
                person.setCountryOfBirth(item.get("countryofbirth").getAsString());
            }
            if (item.has("regionofbirth")) {
                person.setRegionOfBirth(item.get("regionofbirth").getAsString());
            }
            if (item.has("legislationcode")) {
                person.setLegislationCode(item.get("legislationcode").getAsString());
            }
            if (item.has("highesteducationlevel")) {
                person.setHighestEducationLevel(item.get("highesteducationlevel").getAsString());
            }
            if (item.has("addressline1")) {
                person.setAddressLine1(item.get("addressline1").getAsString());
            }
            if (item.has("addladdressattribute3")) {
                person.setAddlAddressAttribute3(item.get("addladdressattribute3").getAsString());
            }
            if (item.has("postalcode")) {
                person.setPostalCode(item.get("postalcode").getAsString());
            }
            if (item.has("townorcity")) {
                person.setTownOrCity(item.get("townorcity").getAsString());
            }
            if (item.has("country")) {
                person.setCountry(item.get("country").getAsString());
            }
            if (item.has("addresstype")) {
                person.setAddressType(item.get("addresstype").getAsString());
            }
            if (item.has("emailaddress")) {
                person.setEmailAddress(item.get("emailaddress").getAsString());
            }
            if (item.has("emailtype")) {
                person.setEmailType(item.get("emailtype").getAsString());
            }
            if (item.has("phonenumber")) {
                person.setPhoneNumber(item.get("phonenumber").getAsString());
            }
            if (item.has("phonetype")) {
                person.setPhoneType(item.get("phonetype").getAsString());
            }
            if (item.has("workertype")) {
                person.setWorkerType(item.get("workertype").getAsString());
            }
            if (item.has("actioncode")) {
                person.setActionCode(item.get("actioncode").getAsString());
            }
            if (item.has("effectiveenddate")) {
                person.setEffectiveEndDate(item.get("effectiveenddate").getAsString());
            }
            if (item.has("assignmentcategory")) {
                person.setAssignmentCategory(item.get("assignmentcategory").getAsString());
            }
            if (item.has("workercategory")) {
                person.setWorkerCategory(item.get("workercategory").getAsString());
            }
            if (item.has("hourlysalariedcode")) {
                person.setHourlySalariedCode(item.get("hourlysalariedcode").getAsString());
            }
            if (item.has("gradecode")) {
                person.setGradeCode(item.get("gradecode").getAsString());
            }
            if (item.has("positioncode")) {
                person.setPositionCode(item.get("positioncode").getAsString());
            }
            if (item.has("jobcode")) {
                person.setJobCode(item.get("jobcode").getAsString());
            }
            if (item.has("locationcode")) {
                person.setLocationCode(item.get("locationcode").getAsString());
            }
            if (item.has("departmentname")) {
                person.setDepartmentName(item.get("departmentname").getAsString());
            }
            if (item.has("frequency")) {
                person.setFrequency(item.get("frequency").getAsString());
            }
            if (item.has("normalhours")) {
                person.setNormalHours(item.get("normalhours").getAsString());
            }
            if (item.has("fullparttime")) {
                person.setFullPartTime(item.get("fullparttime").getAsString());
            }
            if (item.has("persontypecode")) {
                person.setPersonTypeCode(item.get("persontypecode").getAsString());
            }
            if (item.has("bankname")) {
                person.setBankName(item.get("bankname").getAsString());
            }
            if (item.has("accountnumber")) {
                person.setAccountNumber(item.get("accountnumber").getAsString());
            }
            if (item.has("salaryamount")) {
                person.setSalaryAmount(item.get("salaryamount").getAsInt());
            }
            if (item.has("externalidentifiernumber")) {
                person.setExternalIdentifierNumber(item.get("externalidentifiernumber").getAsString());
            }
            if (item.has("externalidentifiertype")) {
                person.setExternalIdentifierType(item.get("externalidentifiertype").getAsString());
            }
            lts.add(person);
        }
        conn.disconnect();
        return lts;
    }

    private static class DefaultTrustManager implements X509TrustManager {

        @Override
        public void checkClientTrusted(X509Certificate[] arg0,
                                       String arg1) throws CertificateException {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] arg0,
                                       String arg1) throws CertificateException {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }
}
