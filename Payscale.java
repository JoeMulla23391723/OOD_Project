
import java.util.HashMap;

public class Payscale {

    //Data fields

    //HashMap for each department/faculty that stores
    private HashMap<String, int[]> presidents = new HashMap<String, int[]>();
    private HashMap<String, int[]> academic = new HashMap<String, int[]>();
    private HashMap<String, int[]> administrative = new HashMap<String, int[]>();
    private HashMap<String, int[]> educationProcurementServices = new HashMap<String, int[]>();
    private HashMap<String, int[]> library = new HashMap<String, int[]>();
    private HashMap<String, int[]> informationTechnology = new HashMap<String, int[]>();
    private HashMap<String, int[]> technical = new HashMap<String, int[]>();
    private HashMap<String, int[]> serviceStaff = new HashMap<String, int[]>();
    private HashMap<String, int[]> teachers = new HashMap<String, int[]>();
    private HashMap<String, int[]> clinical = new HashMap<String, int[]>();
    private HashMap<String, int[]> ulac = new HashMap<String, int[]>();
    private HashMap<String, int[]> coop = new HashMap<String, int[]>();
    private HashMap<String, int[]> researchers = new HashMap<String, int[]>();


    //All professions have a 'level' - the highest level of promotion in the UL professions is 18
    private static int[] promotionLevels = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};


    public Payscale() {
        //Auto-generated constructor stub
    }

    //initialise all pay scales for 'Presednital' faculty

    public void createPresedentialPayscales() {
        presidents.put("president", new int[] {240716});
        presidents.put("vice_president", new int[] {184171});
    }

    //Initialise all pay scales for 'Academic' faculty

    public void createAcademicPayscales() {
        academic.put("full_professor", new int[] {140068, 148055, 156042, 164028, 172016, 177078});
        academic.put("professor", new int[]{101447, 108276, 115107, 121935, 128770, 135598});
        academic.put("associate_professor_a", new int[] {87548, 91018, 94492, 97988, 101461, 104948, 108430, 111916, 115395});
        academic.put("associate_professor_b", new int[] {62069, 73093, 77006, 79703, 83634, 87604, 91563, 95514, 99471});
        academic.put("assistant_professor", new int[] {46955, 49543, 51676, 53644, 55689, 57323, 58990, 60654, 62314, 63965});
        academic.put("teaching_assistant", new int[] {37010, 40061});
    }

    //To save time, the remaining were created using chatGPT

    public void createtAdministrativePayscales() {
        administrative.put("senior_administrative_officer_iii", new int[] {106800, 113990, 121181, 128369, 135565, 142758});
        administrative.put("senior_administrative_officer_ii", new int[] {94941, 98703, 102487, 106270, 110030, 113810, 117589, 121368, 125140});
        administrative.put("senior_administrative_officer_i", new int[] {67132, 69712, 72480, 75725, 79088, 82103, 86389, 90697, 95004, 99396, 103583, 107875});
        administrative.put("senior_executive_administrator", new int[] {58657, 60174, 61704, 63240, 64776, 66317, 68510, 72779, 77291, 79691, 83397});
        administrative.put("executive_administrator", new int[] {44752, 47050, 49360, 51268, 53218, 55306, 57462, 59557, 61263, 62840, 64409});
        administrative.put("senior_administrator", new int[] {39893, 40785, 42037, 43282, 44546, 45799, 47069, 48336, 49613, 50660, 51944, 53265});
        administrative.put("administrator", new int[] {26572, 27495, 28629, 29397, 30060, 30830, 31616, 32491, 33224, 34378, 35541, 36715, 37403, 38396, 39212, 39926, 40912, 41892});
    }

    public void createEducationProcurementServicesPayscales() {
        educationProcurementServices.put("portfolio_manager", new int[] {86389, 90698, 95005, 99396, 103583, 107874});
        educationProcurementServices.put("category_manager", new int[] {67131, 69712, 72480, 75725, 79087, 82103, 86389, 90698});
        educationProcurementServices.put("category_specialist_higher", new int[] {58656, 60174, 61704, 63240, 64775, 66318, 68510, 72779});
        educationProcurementServices.put("category_specialist", new int[] {44752, 47047, 49360, 51269, 53219, 55306, 57462, 59558});
    }

    public void createLibraryPayscales() {
        library.put("sub_librarian", new int[] {64830, 68413, 71505, 74734, 77824, 80106, 83065, 86613, 90308, 93715, 97127, 100531, 102234, 104052, 106850});
        library.put("assistant_librarian_2", new int[] {58657, 60174, 61704, 63240, 64776, 66317, 68510, 72779, 77291, 79691, 83397});
        library.put("assistant_librarian_1", new int[] {44751, 47050, 49364, 51269, 53605, 55126, 56632, 57745, 59104, 60468, 61415, 62371, 64409, 66805, 69293});
        library.put("senior_library_assistant", new int[] {39337, 39808, 40882, 41881, 42439, 44325, 45156, 46242, 47587, 48932, 50539, 51945, 53657});
        library.put("library_assistant", new int[] {33703, 35429, 36934, 37881, 39133, 40055, 41318, 43868, 45138, 45798});
        library.put("library_attendant", new int[] {33403, 34054, 36605, 36966, 36989, 37352, 37141, 38072, 38428, 38443, 38970, 39512, 40039, 40230});
    }

    public void createInformationTechnologyPayscales() {
        informationTechnology.put("analyst_programmer_3", new int[] {67132, 79088, 82103, 86389, 90697, 95004, 99396, 103583, 107875});
        informationTechnology.put("analyst_programmer_2", new int[] {53677, 55287, 56903, 58501, 60116, 61717, 64375, 66805, 69293});
        informationTechnology.put("analyst_programmer_1", new int[] {42012, 44629, 46172, 47611, 49079, 50543, 52039, 53562, 56116, 58164});
        informationTechnology.put("senior_computer_operator", new int[] {42214, 43823, 45475, 46768, 48067, 49369, 50686, 51968, 53657, 55570});
        informationTechnology.put("computer_operator", new int[] {33403, 35114, 36604, 37881, 39133, 40054, 41318, 42586, 43868, 45138});
        informationTechnology.put("print_operator_2", new int[] {31238, 32320, 33844, 35403, 36946, 38331, 39365, 40749, 42093, 43223, 44373});
        informationTechnology.put("print_operator_1", new int[] {29021, 30996, 31738, 32768, 34232, 35719, 37208, 38553, 38583});
    }


    public void createTechncialPayscales() {
        technical.put("chief_technical_officer", new int[] {64838, 67536, 70205, 72494, 75821, 78621});
        technical.put("technical_officer", new int[] {39828, 41606, 43745, 45033, 46408, 49325, 51251, 53228, 55376, 57459});
        technical.put("senior_technical_officer", new int[] {60654, 62799, 65107, 67470, 69827, 71290});
        technical.put("senior_lab_attendant", new int[] {38443, 38970, 39512, 40040, 40229});
        technical.put("lab_attendant", new int[] {33403, 34543, 36604, 36966, 36989, 37352, 37171, 38072, 38429});
    }


    public void createServiceStaffPayscales() {
        serviceStaff.put("sen_porter_attendant", new int[] {41472, 41678, 41873, 41984, 42103, 42213, 42325, 42445, 42563, 42689, 42813, 42936, 43069});
        serviceStaff.put("porter_attendant", new int[] {36456, 37227, 39454, 39644, 39821, 39919, 40032, 40032, 40032, 40032, 40099, 40214, 40327, 40440, 40552});
        serviceStaff.put("grounds_supervisor", new int[] {40712, 40895, 41086, 41188, 41295, 41402, 41498, 41609, 41720, 41828, 41944, 42060, 42165});
        serviceStaff.put("groundsworkperson", new int[] {35063, 35795, 38451, 38637, 38810, 38906, 39009, 39104, 39206, 39304, 39415, 39522, 39632, 39744, 39861});
        serviceStaff.put("senior_aide", new int[] {40827, 41026, 41209, 41317, 41420, 41534, 41635, 41745, 41859, 41975, 42089, 42206, 42318});
        serviceStaff.put("machine_attendant", new int[] {35829, 36585, 39300, 39493, 39671, 39864, 39874, 39979, 40085, 40085, 40085, 40085, 40172, 40286, 40401});
        serviceStaff.put("service_staff", new int[] {35974, 36736, 39461, 39657, 39836, 39933, 40040, 40040, 40040, 40040, 40113, 40226, 40336, 40451, 40566});
        serviceStaff.put("service_staff_shift", new int[] {37129, 37898, 40388, 40578, 40761, 40861, 40973, 41074, 41179, 41284, 41392, 41506, 41613, 41733, 41846});
        serviceStaff.put("plant_maintenance_aide", new int[] {40053, 43995});
        serviceStaff.put("grounds_foreperson", new int[] {49333, 50369, 51204, 52137, 53117, 54078});
    }

    public void createTeachersPayscales() {
        teachers.put("teaching_fellow", new int[] {62069, 73092, 77007, 79703, 83634, 87605, 91562, 95514, 99471});
        teachers.put("university_teacher", new int[] {46955, 49543, 51676, 53644, 55689, 57323, 58990, 60654, 62314, 63965});
        teachers.put("associate_teacher", new int[] {37008, 39126, 40060, 41945, 43130, 44464, 45716, 46978, 47948, 50419});
    }

    public void createClinicalPayscales() {
        clinical.put("regional_supervisors", new int[] {62038});
        clinical.put("regional_placement_facilitator", new int[] {63360, 64724, 66076, 67430, 68853, 70352, 71848, 73048});
        clinical.put("clinical_tutor", new int[] {66452, 69009, 71509, 73344, 75794, 78252});
        clinical.put("clinical_fellow", new int[] {74499, 76258, 78804, 81095, 84824, 88562, 92294});
    }

    public void createUlacPayscales() {
        ulac.put("assistant_senior_instructor", new int[] {31099});
        ulac.put("lead_instructor", new int[] {29370});
        ulac.put("multi_activity_instructor_grade1", new int[] {27639, 25334});
        ulac.put("multi_activity_instructor_grade2", new int[] {25910});
        ulac.put("assistant_instructor", new int[] {25576, 23363});
    }

    public void createCoopPayscales(){
        coop.put("coop_student", new int[] {25306, 25350});
    }

    public void createResearchersPayscales(){
        researchers.put("research_assistant", new int[] {31962, 32782, 33203, 34062, 34945, 35856, 36796, 37419, 38379, 39188, 39847, 40880, 41943});
        researchers.put("post_doctoral_researcher_pd1", new int[] {44847, 45441, 47412, 48671, 49968, 51313});
        researchers.put("post_doctoral_researcher_pd2", new int[] {52715, 54198, 55740, 57332});
        researchers.put("research_fellow", new int[] {63958, 65813, 67224, 69692});
        researchers.put("senior_research_fellow", new int[] {77880, 80070, 81148, 83492});
    }


    // Use the index position of the employee ID to  find their faculty and profession
    //Find out what pay scale the employee is operating on based on by their profession - They pay scales are stored in hash maps for each faculty/department
    public int[] getPayscaleByProfession (int index) {
        int[] payscale = new int[0];
        String profession = Employees.getEmployees().get(index).getJobTitle();
        String faculty = Employees.getEmployees().get(index).getOffice();


        //checks which faculty the employee is a part of, then uses its profession to draw the related pay scale array from the corresponding faculty hash map
        if(faculty.equals("presedent")) {
            payscale = presidents.get(profession);
        }

        if(faculty.equals("academic")) {
            payscale = academic.get(profession);
        }

        if(faculty.equals("administrative")) {
            payscale = administrative.get(profession);
        }

        if(faculty.equals("education_procurement_services")) {
            payscale = educationProcurementServices.get(profession);
        }

        if(faculty.equals("library")) {
            payscale = library.get(profession);
        }
        if(faculty.equals("information_technology")) {
            payscale = informationTechnology.get(profession);
        }

        if(faculty.equals("technical")) {
            payscale = technical.get(profession);
        }

        if(faculty.equals("service_staff")) {
            payscale = serviceStaff.get(profession);
        }

        if(faculty.equals("teachers")) {
            payscale = teachers.get(profession);
        }

        if(faculty.equals("clinical")) {
            payscale = clinical.get(profession);
        }

        if(faculty.equals("ulac")) {
            payscale = ulac.get(profession);
        }

        if(faculty.equals("coop")) {
            payscale = coop.get(profession);
        }

        if(faculty.equals("researchers")) {
            payscale = researchers.get(profession);
        }

        return payscale;
    }

    //Get the employee's salary without any deductions applied - takes the array found in the getPayscaleByProfession method

    public int getSalaryWithoutDeductions(int[] payscale, int level) {
        int i = promotionLevels.length-1;
        while(level<promotionLevels[i]) {
            i--;
        }
        return payscale [i];
    }
}














