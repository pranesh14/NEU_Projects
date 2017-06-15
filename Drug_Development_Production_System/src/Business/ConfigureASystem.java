/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Compound.Compound;
import Business.Disease.Disease;
import Business.Employee.Doctor;
import Business.Employee.Employee;
import Business.Gene.Gene;
import Business.Organization.Organization;
import Business.Patient.Findings;
import Business.Patient.Patient;
import Business.Role.DoctorRole;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author PRPC
 */
public class ConfigureASystem {

    public static Ecosystem configure() {
        Ecosystem system = Ecosystem.getInstance();

        Employee employee = system.getEmployeeDirectory().createEmployee();
        employee.setName("Joseph");
        employee.setAge(40);
        employee.setDesignation("System Administrator");

        UserAccount ua = system.getUserAccountDirectory().createUserAccount();
        ua.setEmployee(employee);
        ua.setUsername("sysadmin");
        ua.setPassword("sysadmin");
        ua.setRole(new SystemAdminRole());

        Compound compound = system.getCompoundList().createCompound();
        compound.setMolecularFormula("Pbc");
        compound.setDescription("The calcining of Litharge is still the standard method of producing red lead, with conversion rates producing various grades commercially supplied by manufacturers ranging from 85 to 98% conversion from PbO to Pb3O4.");
        compound.setMolecularWeight(207.2);
        compound.setName("Calcium plumbate");

        compound = system.getCompoundList().createCompound();
        compound.setMolecularFormula("Pb(C2H3O2)2");
        compound.setDescription("a white crystalline chemical compound with a sweetish taste. It is made by treating lead(II) oxide with acetic acid. Like other lead compounds, it is toxic. Lead acetate is soluble in water and glycerin. With water it forms the trihydrate, Pb(CH3COO)2·3H2O, a colourless or white efflorescent monoclinic crystalline substance.");
        compound.setMolecularWeight(325.3);
        compound.setName("acetate");

        compound = system.getCompoundList().createCompound();
        compound.setMolecularFormula("Pb(N3)2");
        compound.setDescription("Lead azide is prepared by metathesis between sodium azide and lead nitrate. Dextrin can be added to the solution to stabilize the precipitated product. The solid is not very hygroscopic, and water does not reduce its impact sensitivity. It is normally shipped in a dextrinated solution that lowers its sensitivity.");
        compound.setMolecularWeight(291.2);
        compound.setName("azide");

        compound = system.getCompoundList().createCompound();
        compound.setMolecularFormula("PbBr2");
        compound.setDescription("bromide was prevalent in the environment as the result of the use of leaded gasoline. Tetraethyl lead was once widely used to improve the combustion properties of gasoline. To prevent the resulting lead oxides from fouling the engine, gasoline was treated with an organobromine compound that converted lead oxides into the more volatile lead bromide, which was then exhausted from the engine into the environment");
        compound.setMolecularWeight(367.0);
        compound.setName("bromide");

        compound = system.getCompoundList().createCompound();
        compound.setMolecularFormula("PbCO3");
        compound.setDescription("carbonate is the chemical compound PbCO3. It is prepared industrially from  acetate and carbon dioxide It occurs naturally as the mineral cerussite");
        compound.setMolecularWeight(267.2);
        compound.setName("carbonate");

        compound = system.getCompoundList().createCompound();
        compound.setMolecularFormula("PbCl2");
        compound.setDescription("chloride (PbCl2) is an inorganic compound which is a white solid under ambient conditions. It is poorly soluble in water. Lead(II) chloride is one of the most important lead-based reagents. It also occurs naturally in the form of the mineral cotunnite.");
        compound.setMolecularWeight(278.1);
        compound.setName("chloride");

        compound = system.getCompoundList().createCompound();
        compound.setMolecularFormula("PbCrO4");
        compound.setDescription("chromate may also be known as chrome yellow, chromic acid salt, canary chrome yellow 40-2250, chrome green, chrome green UC61, chrome green UC74, chrome green UC76, chrome lemon, crocoite, dianichi chrome yellow G, lemon yellow, king's yellow, Leipzig yellow, lemon yellow, Paris yellow, pigment green 15, plumbous chromate, pure lemon chrome L3GS, and various other names. The mineral crocoite, occurring as orange-yellow prismatic crystals, is a moderately rare mineral known from the oxidation zones of such Pb ore beds, that were affected by chromate-bearing solutions, coming from the oxidation of primary Cr minerals (chromite) of the nearby (ultra)mafic rocks");
        compound.setMolecularWeight(323.2);
        compound.setName("chromate");

        compound = system.getCompoundList().createCompound();
        compound.setMolecularFormula("PbF2");
        compound.setDescription("fluoride (PbF2) is a chemical compound that is an odorless white solid");
        compound.setMolecularWeight(245.2);
        compound.setName("fluoride");

        compound = system.getCompoundList().createCompound();
        compound.setMolecularFormula("PbO2");
        compound.setDescription("This tetrahedral species is isoelectronic with tetrafluoromethane, CF4 and tetrafluoroammonium NF4+, and is valence isoelectronic with many stable and important species including the closely related anion perchlorate, ClO4−. It arises by the reaction of fluoride salts with the Lewis acid BF3, treatment of tetrafluoroboric acid with base, or by treatment of boric acid with hydrofluoric acid");
        compound.setMolecularWeight(239.2);
        compound.setName("fluoroborate");

        compound = system.getCompoundList().createCompound();
        compound.setMolecularFormula("PbI2");
        compound.setDescription("At room temperature, it is a bright yellow odorless crystalline solid, that becomes orange and red when heated.The compound currently has a few specialized applications, such as the manufacture solar cells[5] and X-ray and gamma-ray detectors.[6] Its prepraration is a popular demonstration in basic chemistry education, to teach topics such as double displacement reactions and stoichometry.[7] It is decomposed by light at moderately high temperatures[2] and this effect has been used in a patented photographic process");
        compound.setMolecularWeight(461.0);
        compound.setName("iodide");

        compound = system.getCompoundList().createCompound();
        compound.setMolecularFormula("PbO");
        compound.setDescription("monoxide, is the inorganic compound with the molecular formula PbO. PbO occurs in two polymorphs, one litharge having a tetragonal crystal structure and the other massicot having an orthorhombic crystal structure.");
        compound.setMolecularWeight(223.2);
        compound.setName("monoxide");

        Organization doctorOrganization = new Organization();
        system.setDoctorOrganization(doctorOrganization);
        Findings f = null;
                
        Gene gene = system.getGeneList().addGene();
        gene.setName("FOXP2");
        Disease disease1 = system.getDiseaseList().addDisease();
        disease1.setName("AIDS");
        disease1.setCausingAgent("Human T -cell Leukemia Virus HTLV-III");
        disease1.setSymptoms("Fever, Mouth ulcers");
        disease1.addAffectedGene(gene);
        Disease disease2 = system.getDiseaseList().addDisease();
        disease2.setName("Ascariasis");
        disease2.setCausingAgent("Ascaris lumbricoides");
        disease2.setSymptoms("coughing or gagging ,vomiting roundworms");
        disease2.addAffectedGene(gene);
        Patient patient1 = system.getPatientList().createPatient();
        patient1.setName("RAGHU");
        patient1.setGender("M");
        patient1.setAge(20);
        patient1.setDisease(disease1);
        for(int i=0; i<4; i++)
            f = patient1.addFinding();
        Patient patient2 = system.getPatientList().createPatient();
        patient2.setName("Pooja");
        patient2.setGender("f");
        patient2.setAge(20);
        patient2.setDisease(disease1);
        for(int i=0; i<4; i++)
            f = patient2.addFinding();
        Patient patient3 = system.getPatientList().createPatient();
        patient3.setName("Aravind");
        patient3.setGender("M");
        patient3.setAge(21);
        patient3.setDisease(disease2);
        for(int i=0; i<4; i++)
            f = patient3.addFinding();
        
        Doctor doctor = new Doctor();        
        doctor.setName("JOSEPH");
        doctor.setAge(51);
        doctor.setSex("M");
        doctorOrganization.getEmployeeDirectory().getEmployeeDirectory().add(doctor);
        doctor.addPatient(patient1);
        doctor.addPatient(patient2);
        doctor.addPatient(patient3);
        UserAccount doctorAccount = doctorOrganization.getUserAccountDirectory().createUserAccount();
        doctorAccount.setEmployee(doctor);
        doctorAccount.setUsername("doctor1");
        doctorAccount.setPassword("doctor");
        doctorAccount.setRole(new DoctorRole());
        
        gene = system.getGeneList().addGene();
        disease1 = system.getDiseaseList().addDisease();
        disease2 = system.getDiseaseList().addDisease();
        gene = system.getGeneList().addGene();
        gene.setName("OT");
        disease1.setName("Botulism");
        disease1.setCausingAgent("Clostridium botulinum");
        disease1.setSymptoms("Nausea. Vomiting. Fatigue. Dizziness. Double vision. Dry skin, mouth and throat.");
        disease1.addAffectedGene(gene);
        disease2.setName("Chickenpox");
        disease2.setCausingAgent("Varicella Virus");
        disease2.setSymptoms("rash include: fever. tiredness. loss of appetite. headache.");
        disease2.addAffectedGene(gene);
        Patient patient5 = system.getPatientList().createPatient();
        Patient patient4 = system.getPatientList().createPatient();
        patient4.setName("RAM");
        patient4.setGender("M");
        patient4.setAge(22);
        patient4.setDisease(disease1);
        for(int i=0; i<4; i++)
            f = patient4.addFinding();
        patient5.setName("JO");
        patient5.setGender("M");
        patient5.setAge(35);
        patient5.setDisease(disease1);
        for(int i=0; i<4; i++)
            f = patient5.addFinding();
        Patient patient7 = system.getPatientList().createPatient();
        patient7.setName("BABU");
        patient7.setGender("M");
        patient7.setAge(20);
        patient7.setDisease(disease1);
        for(int i=0; i<4; i++)
            f = patient7.addFinding();
        Patient patient8 = system.getPatientList().createPatient();
        patient8.setName("PRIYA");
        patient8.setGender("F");
        patient8.setAge(35);
        patient8.setDisease(disease2);
        for(int i=0; i<4; i++)
            f = patient8.addFinding();
        doctor = new Doctor();
        doctor.setName("SAM");
        doctor.setAge(56);
        doctor.setSex("M");
        doctorOrganization.getEmployeeDirectory().getEmployeeDirectory().add(doctor);
        doctor.addPatient(patient5);
        doctor.addPatient(patient7);
        doctorAccount = doctorOrganization.getUserAccountDirectory().createUserAccount();
        doctorAccount.setEmployee(doctor);
        doctorAccount.setUsername("doctor2");
        doctorAccount.setPassword("doctor");        
        doctorAccount.setRole(new DoctorRole());
        doctor = new Doctor();
        doctor.setName("RAM");
        doctor.setAge(59);
        doctor.setSex("M");
        doctorOrganization.getEmployeeDirectory().getEmployeeDirectory().add(doctor);
        doctor.addPatient(patient8);
        doctorAccount = doctorOrganization.getUserAccountDirectory().createUserAccount();
        doctorAccount.setEmployee(doctor);
        doctorAccount.setUsername("doctor3");
        doctorAccount.setPassword("doctor");
        doctorAccount.setRole(new DoctorRole());

        gene = system.getGeneList().addGene();
        disease1 = system.getDiseaseList().addDisease();
        disease2 = system.getDiseaseList().addDisease();
        gene.setName("AVPR1a ");
        disease1.setName("Cholera");
        disease1.setCausingAgent("Varibrio Cholerae");
        disease1.setSymptoms("Nausea and vomiting");
        disease1.addAffectedGene(gene);
        disease2.setName("Dengue");
        disease2.setCausingAgent("Dengue Virus (arbovirus)");
        disease2.setSymptoms("Sudden, high fever. Severe headaches. Pain behind the eyes. Severe joint and muscle pain. Fatigue. Nausea. Vomiting. Skin rash");
        disease2.addAffectedGene(gene);
        Patient patient9 = system.getPatientList().createPatient();
        patient9.setName("AKIL");
        patient9.setGender("M");
        patient9.setAge(20);
        patient9.setDisease(disease1);
        for(int i=0; i<4; i++)
            f = patient9.addFinding();
        Patient patient10 = system.getPatientList().createPatient();
        patient10.setName("SAM");
        patient10.setGender("M");
        patient10.setAge(20);
        patient10.setDisease(disease1);
        for(int i=0; i<4; i++)
            f = patient10.addFinding();
        Patient patient11 = system.getPatientList().createPatient();
        patient11.setName("AKILA");
        patient11.setGender("F");
        patient11.setAge(20);
        patient11.setDisease(disease2);
        for(int i=0; i<4; i++)
            f = patient11.addFinding();
        Patient patient12 = system.getPatientList().createPatient();
        patient12.setName("TARU");
        patient12.setGender("F");
        patient12.setAge(25);
        patient12.setDisease(disease2);
        for(int i=0; i<4; i++)
            f = patient12.addFinding();        
        doctor = new Doctor();
        doctor.setName("PARNESH");
        doctor.setAge(91);
        doctor.setSex("M");   
        doctorOrganization.getEmployeeDirectory().getEmployeeDirectory().add(doctor);
        doctor.addPatient(patient9);
        doctor.addPatient(patient10);
        doctorAccount = doctorOrganization.getUserAccountDirectory().createUserAccount();
        doctorAccount.setEmployee(doctor);
        doctorAccount.setUsername("doctor4");
        doctorAccount.setPassword("doctor");
        doctorAccount.setRole(new DoctorRole());
        
        doctor = new Doctor();
        doctor.setName("BALA");
        doctor.setAge(85);
        doctor.setSex("M");       
        doctorOrganization.getEmployeeDirectory().getEmployeeDirectory().add(doctor);
        doctor.addPatient(patient11);
        doctor.addPatient(patient12);
        doctorAccount = doctorOrganization.getUserAccountDirectory().createUserAccount();
        doctorAccount.setEmployee(doctor);
        doctorAccount.setUsername("doctor5");
        doctorAccount.setPassword("doctor");
        doctorAccount.setRole(new DoctorRole());

        gene = system.getGeneList().addGene();
        disease1 = system.getDiseaseList().addDisease();
        disease2 = system.getDiseaseList().addDisease();
        gene.setName("SRY ");
        disease1.setName("Filariasis");
        disease1.setCausingAgent("Wuchereria bancrofti");
        disease1.setSymptoms("thickened skin and massive swelling");
        disease1.addAffectedGene(gene);
        disease2.setName("Gonorrhoea");
        disease2.setCausingAgent("Diplococcus");
        disease2.setSymptoms("pain or a burning sensation when urinating. inflammation (swelling) of the foreskin.");
        disease2.addAffectedGene(gene);
        Patient patient14 = system.getPatientList().createPatient();
        patient14.setName("SAMI");
        patient14.setGender("M");
        patient14.setAge(28);
        patient14.setDisease(disease1);
        for(int i=0; i<4; i++)
            f = patient14.addFinding();
        Patient patient15 = system.getPatientList().createPatient();
        patient15.setName("ANU");
        patient15.setGender("F");
        patient15.setAge(27);
        patient15.setDisease(disease2);
        for(int i=0; i<4; i++)
            f = patient15.addFinding();
        doctor = new Doctor();
        doctor.setName("HARI");
        doctor.setAge(82);
        doctor.setSex("M");       
        doctorOrganization.getEmployeeDirectory().getEmployeeDirectory().add(doctor);
        doctor.addPatient(patient14);
        doctorAccount = doctorOrganization.getUserAccountDirectory().createUserAccount();
        doctorAccount.setEmployee(doctor);
        doctorAccount.setUsername("doctor6");
        doctorAccount.setPassword("doctor");        
        doctorAccount.setRole(new DoctorRole());
        doctor = new Doctor();
        doctor.setName("POOJITHA");
        doctor.setAge(51);
        doctor.setSex("F");       
        doctorOrganization.getEmployeeDirectory().getEmployeeDirectory().add(doctor);
        doctor.addPatient(patient15);
        doctorAccount = doctorOrganization.getUserAccountDirectory().createUserAccount();
        doctorAccount.setEmployee(doctor);
        doctorAccount.setUsername("doctor7");
        doctorAccount.setPassword("doctor");
        doctorAccount.setRole(new DoctorRole());

        gene = system.getGeneList().addGene();
        disease1 = system.getDiseaseList().addDisease();
        disease2 = system.getDiseaseList().addDisease();
        gene.setName("OPN1LW ");
        disease1.setName("Herpes");
        disease1.setCausingAgent("Herps Virus");
        disease1.setSymptoms("pain, itching, or tingling");
        disease1.addAffectedGene(gene);
        disease2.setName("Measles");
        disease2.setCausingAgent("ParaMyxoVirus");
        disease2.setSymptoms("high fever, cough");
        disease2.addAffectedGene(gene);
        Patient patient17 = system.getPatientList().createPatient();
        patient17.setName("PRANESH");
        patient17.setGender("M");
        patient17.setAge(29);
        patient17.setDisease(disease1);
        for(int i=0; i<4; i++)
            f = patient17.addFinding();
        Patient patient19 = system.getPatientList().createPatient();
        patient19.setName("ARCHAN");
        patient19.setGender("F");
        patient19.setAge(25);
        patient19.setDisease(disease2);
        for(int i=0; i<4; i++)
            f = patient19.addFinding();        
        doctor = new Doctor();
        doctor.setName("RAJATH");
        doctor.setAge(85);
        doctor.setSex("M");       
        doctorOrganization.getEmployeeDirectory().getEmployeeDirectory().add(doctor);
        doctor.addPatient(patient17);
        doctorAccount = doctorOrganization.getUserAccountDirectory().createUserAccount();
        doctorAccount.setEmployee(doctor);
        doctorAccount.setUsername("doctor8");
        doctorAccount.setPassword("doctor");    
        doctorAccount.setRole(new DoctorRole());
        doctor = new Doctor();
        doctor.setName("RASHMI");
        doctor.setAge(86);
        doctor.setSex("F");       
        doctorOrganization.getEmployeeDirectory().getEmployeeDirectory().add(doctor);
        doctor.addPatient(patient19);  
        doctorAccount = doctorOrganization.getUserAccountDirectory().createUserAccount();
        doctorAccount.setEmployee(doctor);
        doctorAccount.setUsername("doctor9");
        doctorAccount.setPassword("doctor");
        doctorAccount.setRole(new DoctorRole());

        gene = system.getGeneList().addGene();
        disease1 = system.getDiseaseList().addDisease();
        disease2 = system.getDiseaseList().addDisease();
        gene.setName("RB1 ");
        disease1.setName("Mumps");
        disease1.setCausingAgent("Paramyxovirus");
        disease1.setSymptoms("Headache. Muscle aches. Weakness and fatigue.");
        disease1.addAffectedGene(gene);
        disease2.setName("Plague");
        disease2.setCausingAgent("Yersinia Pestis");
        disease2.setSymptoms("Fever and chills. Extreme weakness. Abdominal pain, diarrhea and vomiting.");
        disease2.addAffectedGene(gene);
        Patient patient21 = system.getPatientList().createPatient();
        Patient patient20 = system.getPatientList().createPatient();
        patient20.setName("POORI");
        patient20.setGender("F");
        patient20.setAge(21);
        patient20.setDisease(disease1);
        for(int i=0; i<4; i++)
            f = patient20.addFinding();
        patient21.setName("ABI");
        patient21.setGender("M");
        patient21.setAge(29);
        patient21.setDisease(disease1);
        for(int i=0; i<4; i++)
            f = patient21.addFinding();
        Patient patient22 = system.getPatientList().createPatient();
        patient22.setName("ABIJI");
        patient22.setGender("M");
        patient22.setAge(20);
        patient22.setDisease(disease1);
        for(int i=0; i<4; i++)
            f = patient22.addFinding();
        Patient patient23 = system.getPatientList().createPatient();
        patient23.setName("RAAMA");
        patient23.setGender("F");
        patient23.setAge(26);
        patient23.setDisease(disease2);
        for(int i=0; i<4; i++)
            f = patient23.addFinding();
        Patient patient24 = system.getPatientList().createPatient();
        patient24.setName("REKA");
        patient24.setGender("F");
        patient24.setAge(35);
        patient24.setDisease(disease2);
        for(int i=0; i<4; i++)
            f = patient24.addFinding();
        Patient patient25 = system.getPatientList().createPatient();
        patient25.setName("VINOTH");
        patient25.setGender("M");
        patient25.setAge(20);
        patient25.setDisease(disease1);
        for(int i=0; i<4; i++)
            f = patient25.addFinding();        
        doctor = new Doctor();
        doctor.setName("SIMBU");
        doctor.setAge(51);
        doctor.setSex("M");       
        doctorOrganization.getEmployeeDirectory().getEmployeeDirectory().add(doctor);
        doctor.addPatient(patient20);
        doctor.addPatient(patient21);
        doctor.addPatient(patient22);
        doctorAccount = doctorOrganization.getUserAccountDirectory().createUserAccount();
        doctorAccount.setEmployee(doctor);
        doctorAccount.setUsername("doctor10");
        doctorAccount.setPassword("doctor");        
        doctorAccount.setRole(new DoctorRole());
        doctor = new Doctor();
        doctor.setName("POOJA");
        doctor.setAge(75);
        doctor.setSex("F");       
        doctorOrganization.getEmployeeDirectory().getEmployeeDirectory().add(doctor);
        doctor.addPatient(patient23);
        doctor.addPatient(patient24);
        doctor.addPatient(patient25);
        doctorAccount = doctorOrganization.getUserAccountDirectory().createUserAccount();
        doctorAccount.setEmployee(doctor);
        doctorAccount.setUsername("doctor11");
        doctorAccount.setPassword("doctor");
        doctorAccount.setRole(new DoctorRole());

        gene = system.getGeneList().addGene();
        disease1 = system.getDiseaseList().addDisease();
        disease2 = system.getDiseaseList().addDisease();
        gene.setName("FIT2 ");
        disease1.setName("Rabies");
        disease1.setCausingAgent("rhabdovirus");
        disease1.setSymptoms("headache. nausea. stomach pain. muscle aches. dizziness.");
        disease1.addAffectedGene(gene);
        disease2.setName("Syphilis");
        disease2.setCausingAgent("Treponema Palladium");
        disease2.setSymptoms("mild flu-like symptoms, like a slight fever, feeling tired, sore throat, swollen glands, headache, and muscle aches.");
        disease2.addAffectedGene(gene);
        Patient patient26 = system.getPatientList().createPatient();
        patient26.setName("VINOD");
        patient26.setGender("M");
        patient26.setAge(50);
        patient26.setDisease(disease1);
        for(int i=0; i<4; i++)
            f = patient26.addFinding();
        Patient patient27 = system.getPatientList().createPatient();
        patient27.setName("PRASU");
        patient27.setGender("F");
        patient27.setAge(26);
        patient27.setDisease(disease2);
        for(int i=0; i<4; i++)
            f = patient27.addFinding();
        doctor = new Doctor();
        doctor.setName("SAMI");
        doctor.setAge(84);
        doctor.setSex("M");       
        doctorOrganization.getEmployeeDirectory().getEmployeeDirectory().add(doctor);
        doctor.addPatient(patient26);
        doctorAccount = doctorOrganization.getUserAccountDirectory().createUserAccount();
        doctorAccount.setEmployee(doctor);
        doctorAccount.setUsername("doctor12");
        doctorAccount.setPassword("doctor");        
        doctorAccount.setRole(new DoctorRole());
        doctor = new Doctor();
        doctor.setName("MEENA");
        doctor.setAge(51);
        doctor.setSex("F");       
        doctorOrganization.getEmployeeDirectory().getEmployeeDirectory().add(doctor);
        doctor.addPatient(patient27); 
        doctorAccount = doctorOrganization.getUserAccountDirectory().createUserAccount();
        doctorAccount.setEmployee(doctor);
        doctorAccount.setUsername("doctor13");
        doctorAccount.setPassword("doctor");
        doctorAccount.setRole(new DoctorRole());

        gene = system.getGeneList().addGene();
        disease1 = system.getDiseaseList().addDisease();
        disease2 = system.getDiseaseList().addDisease();
        gene.setName("Sonic the Hedgehog ");
        disease1.setName("Tetanus");
        disease1.setCausingAgent("Clostidium tetani");
        disease1.setSymptoms("Spasms and stiffness in your jaw muscles (trismus) Stiffness of your neck muscles");
        disease1.addAffectedGene(gene);
        disease2.setName("Cancer");
        disease2.setCausingAgent("Epstein-Barr virus , hepatitis B virus");
        disease2.setSymptoms("Unusual bleeding , Coughing up blood");
        disease2.addAffectedGene(gene);
        Patient patient28 = system.getPatientList().createPatient();
        patient28.setName("PRASANTHI");
        patient28.setGender("F");
        patient28.setAge(75);
        patient28.setDisease(disease1);
        for(int i=0; i<4; i++)
            f = patient28.addFinding();
        Patient patient29 = system.getPatientList().createPatient();
        patient29.setName("BABA");
        patient29.setGender("M");
        patient29.setAge(91);
        patient29.setDisease(disease1);
        for(int i=0; i<4; i++)
            f = patient29.addFinding();
        Patient patient30 = system.getPatientList().createPatient();
        patient30.setName("RAJ");
        patient30.setGender("M");
        patient30.setAge(27);
        patient30.setDisease(disease1);
        for(int i=0; i<4; i++)
            f = patient30.addFinding();
        Patient patient31 = system.getPatientList().createPatient();
        patient31.setName("SUJI");
        patient31.setGender("F");
        patient31.setAge(61);
        patient31.setDisease(disease2);
        for(int i=0; i<4; i++)
            f = patient31.addFinding();        
        doctor = new Doctor();
        doctor.setName("JONY");
        doctor.setAge(51);
        doctor.setSex("M");       
        doctorOrganization.getEmployeeDirectory().getEmployeeDirectory().add(doctor);
        doctor.addPatient(patient28);
        doctor.addPatient(patient29);
        doctorAccount = doctorOrganization.getUserAccountDirectory().createUserAccount();
        doctorAccount.setEmployee(doctor);
        doctorAccount.setUsername("doctor14");
        doctorAccount.setPassword("doctor");        
        doctorAccount.setRole(new DoctorRole());
        doctor = new Doctor();
        doctor.setName("SUJITHA");
        doctor.setAge(59);
        doctor.setSex("F");       
        doctorOrganization.getEmployeeDirectory().getEmployeeDirectory().add(doctor);
        doctor.addPatient(patient30);
        doctor.addPatient(patient31);  
        doctorAccount = doctorOrganization.getUserAccountDirectory().createUserAccount();
        doctorAccount.setEmployee(doctor);
        doctorAccount.setUsername("doctor15");
        doctorAccount.setPassword("doctor");
        doctorAccount.setRole(new DoctorRole());
        return system;
    }

}
