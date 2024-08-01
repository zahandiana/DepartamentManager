## Sistem de Gestionare a Departamentelor

## Prezentare Generală

Acest proiect este un Sistem de Gestionare a Departamentelor, dezvoltat în Java. Proiectul este conceput pentru a gestiona departamentele și angajații din cadrul unei organizații. Sistemul este structurat folosind arhitectura Model-View-Controller (MVC), care promovează separarea responsabilităților și ușurează întreținerea și extinderea.

## Structura Proiectului

Proiectul este compus din următoarele componente principale:

### 1. Modele
- **Department.java**: Reprezintă entitatea Departament cu atribute precum numele departamentului, id-ul și alte câmpuri relevante.
- **Employee.java**: Reprezintă entitatea Angajat cu atribute precum numele angajatului, id-ul, afilierea la departament și altele.

### 2. Controlere
- **DepartmentController.java**: Gestionează cererile HTTP legate de operațiunile asupra departamentelor, cum ar fi crearea, actualizarea, obținerea și ștergerea departamentelor.
- **EmployeeController.java**: Administrează cererile HTTP pentru operațiunile legate de angajați, incluzând crearea, actualizarea, obținerea și ștergerea înregistrărilor angajaților.

### 3. Repozitorii
- **DepartmentRepository.java**: Interfațează cu baza de date pentru operațiunile CRUD (Creare, Citire, Actualizare, Ștergere) pe entitatea Departament.
- **EmployeeRepository.java**: Administrează operațiunile CRUD pentru entitatea Angajat în baza de date.

### 4. Servicii
- **DepartmentService.java**: Conține logica de afaceri pentru gestionarea operațiunilor legate de departamente, interacționând cu DepartmentRepository.
- **EmployeeService.java**: Încapsulează logica de afaceri pentru activitățile legate de angajați, lucrând strâns cu EmployeeRepository.

## Configurare și Utilizare

### Cerințe Preliminare
- Java Development Kit (JDK) 8 sau mai nou
- Un mediu de dezvoltare integrat (IDE) precum IntelliJ IDEA
- Un sistem de baze de date (ex. MySQL, PostgreSQL) configurat cu tabelele necesare

### Instalare

1. **Clonarea Repozitoriului:**
   ```bash
   git clone https://github.com/numele-tau/department-manager-system.git
   ```
2. **Navigare în Directorul Proiectului:**
   ```bash
   cd department-manager-system
   ```
3. **Deschiderea Proiectului în IDE-ul Tău:**
   - Importați proiectul în IDE-ul dvs. (ex. IntelliJ IDEA) ca proiect Maven sau Gradle.
4. **Configurarea Setărilor Bazei de Date:**
   - Actualizați configurația bazei de date în `application.properties` (sau echivalent) pentru a se potrivi cu configurarea dvs. locală.
5. **Rularea Aplicației:**
   - Utilizați instrumentele integrate ale IDE-ului sau linia de comandă pentru a rula aplicația.

### Utilizare

După ce aplicația este pornită și funcțională, puteți folosi unelte precum Postman sau un browser web pentru a interacționa cu endpoint-urile definite în `DepartmentController` și `EmployeeController`. Endpoint-urile suportă în general operațiuni precum crearea, actualizarea, obținerea și ștergerea departamentelor și angajaților.

