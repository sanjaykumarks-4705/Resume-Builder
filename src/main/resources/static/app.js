const BASE_URL = "http://localhost:8080";

async function register() {

    const user = {

        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        password: document.getElementById("password").value

    };

    const response = await fetch(BASE_URL + "/api/auth/register", {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify(user)

    });

    if (response.ok) {

        alert("Registration Successful");

        window.location.href = "login.html";

    } else {

        alert("Registration Failed");

    }

}

async function login() {

    const loginData = {

        email: document.getElementById("loginEmail").value,

        password: document.getElementById("loginPassword").value

    };

    const response = await fetch(BASE_URL + "/api/auth/login", {

        method: "POST",

        headers: {

            "Content-Type": "application/json"

        },

        body: JSON.stringify(loginData)

    });

    if (response.ok) {

        alert("Login Successful");

        window.location.href = "resume.html";

    } else {

        alert("Invalid Email or Password");

    }

}

async function getAllUsers() {

    const response = await fetch(BASE_URL + "/api/users");

    const users = await response.json();

    const total = document.getElementById("totalUsers");

    if (total != null)
        total.innerHTML = users.length;

    const table = document.getElementById("result");

    if (table == null)
        return;

    let output = "";

    users.forEach(user => {

        output += `

        <tr>

            <td>${user.id}</td>

            <td>${user.name}</td>

            <td>${user.email}</td>

        </tr>

        `;

    });

    table.innerHTML = output;

}

async function createResume() {

    const resume = {

        userId: document.getElementById("userId").value,

        fullName: document.getElementById("fullName").value,

        phone: document.getElementById("phone").value,

        address: document.getElementById("address").value,

        education: document.getElementById("education").value,

        skills: document.getElementById("skills").value,

        experience: document.getElementById("experience").value

    };

    const response = await fetch(BASE_URL + "/api/resume", {

        method: "POST",

        headers: {

            "Content-Type": "application/json"

        },

        body: JSON.stringify(resume)

    });

    if (response.ok) {

        alert("Resume Created Successfully");

        clearForm();

        getAllResumes();

    } else {

        alert("Failed to Create Resume");

    }

}

async function getAllResumes() {

    const response = await fetch(BASE_URL + "/api/resume");

    const resumes = await response.json();

    const total = document.getElementById("totalResume");

    if (total != null)
        total.innerHTML = resumes.length;

    const table = document.getElementById("result");

    if (table == null)
        return;

    let output = "";

    resumes.forEach((r , index) => {

        output += `

        <tr>
        <td>${index + 1}</td>

        <td>${r.id}</td>

        <td>${r.fullName}</td>



        <td>

        <button class="view" onclick="loadResume(${r.id})">

        View

        </button>

        <button class="edit" onclick="fillResume(${r.id})">

        Edit

        </button>

        <button class="delete" onclick="deleteResumeById(${r.id})">

        Delete

        </button>

        </td>

        </tr>

        `;

    });

    table.innerHTML = output;

}
async function loadResume(id) {

    const response = await fetch(BASE_URL + "/api/resume/" + id);

    const r = await response.json();

    document.getElementById("resumeDetails").innerHTML = `

        <p><b>Name :</b>${r.fullName}</p>

        <p><b>Register No :</b> ${r.userId}</p>

        <p><b>Phone :</b> ${r.phone}</p>

        <p><b>Address :</b> ${r.address}</p>

        <p><b>Education :</b> ${r.education}</p>

        <p><b>Skills :</b> ${r.skills}</p>

        <p><b>Experience :</b> ${r.experience}</p>

    `;

}

async function fillResume(id) {

    const response = await fetch(BASE_URL + "/api/resume/" + id);

    const r = await response.json();

    document.getElementById("updateId").value = r.id;

    document.getElementById("userId").value = r.userId;

    document.getElementById("fullName").value = r.fullName;

    document.getElementById("phone").value = r.phone;

    document.getElementById("address").value = r.address;

    document.getElementById("education").value = r.education;

    document.getElementById("skills").value = r.skills;

    document.getElementById("experience").value = r.experience;

}

async function updateResume() {

    const id = document.getElementById("updateId").value;

    const resume = {

        userId: document.getElementById("userId").value,

        fullName: document.getElementById("fullName").value,

        phone: document.getElementById("phone").value,

        address: document.getElementById("address").value,

        education: document.getElementById("education").value,

        skills: document.getElementById("skills").value,

        experience: document.getElementById("experience").value

    };

    const response = await fetch(BASE_URL + "/api/resume/" + id, {

        method: "PUT",

        headers: {

            "Content-Type": "application/json"

        },

        body: JSON.stringify(resume)

    });

    if (response.ok) {

        alert("Resume Updated Successfully");

        clearForm();

        getAllResumes();

    } else {

        alert("Update Failed");

    }

}

async function deleteResume() {

    const id = document.getElementById("deleteId").value;

    const response = await fetch(BASE_URL + "/api/resume/" + id, {
        method: "DELETE"
    });

    const result = await response.json();

    alert(result.message);

    if (result.message === "Resume Deleted Successfully") {
        getAllResumes();
    }
}

function deleteResumeById(id) {

    document.getElementById("deleteId").value = id;

    deleteResume();

}
async function getResumeById() {

    const id = document.getElementById("resumeId").value;

    loadResume(id);

}
function clearForm() {

    document.getElementById("userId").value = "";
    document.getElementById("fullName").value = "";
    document.getElementById("phone").value = "";
    document.getElementById("address").value = "";
    document.getElementById("education").value = "";
    document.getElementById("skills").value = "";
    document.getElementById("experience").value = "";
    document.getElementById("updateId").value = "";

}