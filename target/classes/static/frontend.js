function addDepartment() {
    const departmentId = document.getElementById("departmentId").value;
    const departmentDescription = document.getElementById("departmentDescription").value;
    const parentDepartmentId = document.getElementById("parentDepartmentId").value;

    // Verifică dacă toate câmpurile sunt completate
    if (!departmentId || !departmentDescription) {
        alert("Please fill in both ID and Description fields.");
        return;
    }

    const department = {
        id: parseInt(departmentId),
        description: departmentDescription,
        parent: { id: parseInt(parentDepartmentId) }
    };

    const xhr = new XMLHttpRequest();
    xhr.open("POST", "/create", true);
    xhr.setRequestHeader("Content-Type", "application/json");

    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                alert("Department added successfully!");
            } else {
                alert("Error adding department. Please try again.");
            }
        }
    };

    xhr.send(JSON.stringify(department));
}



function updateDepartmentDescription() {
    const departmentId = document.getElementById("updateDepartmentId").value;
    const newDescription = document.getElementById("newDescription").value;

    // Verifică dacă ambele câmpuri sunt completate
    if (!departmentId || !newDescription) {
        alert("Please fill in both fields.");
        return;
    }

    const xhr = new XMLHttpRequest();
    xhr.open("PUT", `/department/${departmentId}`, true);
    xhr.setRequestHeader("Content-Type", "application/json");

    const updatedDepartment = {
        description: newDescription,
        // Adaugă și parent_id în obiectul de actualizare, chiar dacă nu se schimbă
        parent: { id: parseInt(document.getElementById("parentDepartmentId").value) }
    };

    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                alert("Department description updated successfully!");
            } else {
                alert("Error updating department description. Please try again.");
            }
        }
    };

    xhr.send(JSON.stringify(updatedDepartment));
}

function addEmployee() {
    const employeeId = document.getElementById("employeeId").value;
    const employeeName = document.getElementById("employeeName").value;
    const employeeDepartmentId = document.getElementById("employeeDepartmentId").value;
    const employeeManagerId = document.getElementById("employeeManagerId").value;
    const employeeEmail = document.getElementById("employeeEmail").value;

    // Verifică dacă toate câmpurile sunt completate
    if (!employeeId || !employeeName || !employeeDepartmentId || !employeeManagerId || !employeeEmail) {
        alert("Please fill in all fields.");
        return;
    }

    const employee = {
        id: parseInt(employeeId),
        name: employeeName,
        departmentId: parseInt(employeeDepartmentId),
        managerId: parseInt(employeeManagerId),
        email: employeeEmail
    };

    const xhr = new XMLHttpRequest();
    xhr.open("POST", "/createEmployee", true);
    xhr.setRequestHeader("Content-Type", "application/json");

    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                alert("Employee added successfully!");
            } else {
                alert("Error adding employee. Please try again.");
            }
        }
    };

    xhr.send(JSON.stringify(employee));
}



function getEmployeeDetails(employeeId, callback) {
    const xhr = new XMLHttpRequest();
    xhr.open("GET", `/employee/${employeeId}`, true);

    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            const employeeDetails = JSON.parse(xhr.responseText);
            callback(employeeDetails);
        }
    };

    xhr.send();
}

function updateEmployeeEmail() {
    const employeeId = document.getElementById("updateEmployeeId").value;
    const newEmail = document.getElementById("newEmail").value;

    // Verifică dacă ambele câmpuri sunt completate
    if (!employeeId || !newEmail) {
        alert("Please fill in both fields.");
        return;
    }

    // Obține informațiile curente ale angajatului
    getEmployeeDetails(employeeId, function(existingEmployee) {
        const xhr = new XMLHttpRequest();
        xhr.open("PUT", `/employee/${employeeId}`, true);
        xhr.setRequestHeader("Content-Type", "application/json");

        const updatedEmployee = {
            id: existingEmployee.id,
            name: existingEmployee.name,
            departmentId: existingEmployee.departmentId,
            managerId: existingEmployee.managerId,
            email: newEmail
        };

        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4) {
                if (xhr.status === 200) {
                    alert("Employee email updated successfully!");
                } else {
                    alert("Error updating employee email. Please try again.");
                }
            }
        };

        xhr.send(JSON.stringify(updatedEmployee));
    });
}



function deleteEmployee() {
    const employeeId = document.getElementById("deleteEmployeeId").value;

    // Verifică dacă câmpul este completat
    if (!employeeId) {
        alert("Please fill in the ID field.");
        return;
    }

    fetch(`/employee/${employeeId}`, {
        method: 'DELETE',
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("Error deleting employee. Please try again.");
        }
        return response.text();
    })
    .then(data => {
        alert("Employee deleted successfully!");
    })
    .catch(error => {
        alert(error.message);
    });
}

function deleteDepartment() {
    const departmentId = document.getElementById("deleteDepartmentId").value;

    // Verifică dacă câmpul este completat
    if (!departmentId) {
        alert("Please fill in the ID field.");
        return;
    }

    fetch(`/department/${departmentId}`, {
        method: 'DELETE',
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("Error deleting department. Please try again.");
        }
        return response.text();
    })
    .then(data => {
        alert("Department deleted successfully!");
    })
    .catch(error => {
        alert(error.message);
    });
}




