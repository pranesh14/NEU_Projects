function loadDoc() {
    var temp = window.location.search;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var jsonObj = this.responseText;
            var obj = JSON.parse(jsonObj);
            obj.contacts.sort(function(a, b) {
                var nameA = a.last_name;
                var nameB = b.last_name;
                if (nameA < nameB) {
                    return -1;
                }
                if (nameA > nameB) {
                    return 1;
                }
                return 0;
            });
            for (var i = 0; i < obj.contacts.length; i++) {
                var contactName = obj.contacts[i].first_name + ' ' + obj.contacts[i].last_name;
                var contactId = obj.contacts[i].id;
                var list = document.querySelector('.list'),
                    div = document.createElement('div');
                div.innerHTML = "<a id='viewdetail' href='detailview.html?id=" + contactId + "'>" + contactName + "</a>";
                list.appendChild(div);
            }
            if (temp != "") {
                var list = document.querySelector('.list'),
                    div = document.createElement('div');
                var t = temp.substring(1);
                var arr = t.split('&');
                var fname = arr[0];
                var n = fname.indexOf("=");
                fname = fname.substring(n + 1);
                var lname = arr[1];
                var n = lname.indexOf("=");
                lname = lname.substring(n + 1);
                var dob = arr[2];
                var n = dob.indexOf("=");
                dob = dob.substring(n + 1);
                var addr = arr[3];
                var n = addr.indexOf("=");
                addr = addr.substring(n + 1);
                var num = arr[4];
                var n = num.indexOf("=");
                num = num.substring(n + 1);
                div.innerHTML = "<a id='viewdetail' href='detailview.html?fname=" + fname + "&lname=" + lname + "&dob=" + dob + "&addr=" + addr + "&num=" + num + "'>" + fname + ' ' + lname + "</a>";
                list.appendChild(div);
            }
        }
    };
    xhttp.open("GET", "./json/contacts.json", true);
    xhttp.send();
}

function loadDetails() {
    var temp = window.location.search;
    if (temp.substring(1, 3) == "id") {
        var id = temp.substring(4);
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                var jsonObj = this.responseText;
                var obj = JSON.parse(jsonObj);
                for (var i = 0; i < obj.contacts.length; i++) {
                    var contactId = obj.contacts[i].id;
                    if (contactId == id) {
                        var contactFirstName = obj.contacts[i].first_name;
                        var contactLastName = obj.contacts[i].last_name;
                        var contactNumber = obj.contacts[i].number;
                        var contactAddress = obj.contacts[i].address;
                        var contactBirthday = obj.contacts[i].birthday;
                        var list = document.querySelector('.details'),
                            div = document.createElement('div');
                        div.innerHTML = "<img src='http://2.gravatar.com/avatar/8b91904f96464928ad93807b5fa9a611'>";
                        div.innerHTML += "<div id='detail'>First Name: " + contactFirstName + "</div>";
                        div.innerHTML += "<div id='detail'>Last Name: " + contactLastName + "</div>";
                        div.innerHTML += "<div id='detail'>Number: " + contactNumber + "</div>";
                        div.innerHTML += "<div id='detail'>Address: " + contactAddress + "</div>";
                        div.innerHTML += "<div id='detail'>Birthday: " + contactBirthday + "</div>";
                        list.appendChild(div);
                    }
                }
            }
        };
        xhttp.open("GET", "./json/contacts.json", true);
        xhttp.send();
    } else {
        var list = document.querySelector('.details'),
            div = document.createElement('div');
        var t = temp.substring(1);
        var arr = t.split('&');
        var fname = arr[0];
        var n = fname.indexOf("=");
        fname = fname.substring(n + 1);
        var lname = arr[1];
        var n = lname.indexOf("=");
        lname = lname.substring(n + 1);
        var dob = arr[2];
        var n = dob.indexOf("=");
        dob = dob.substring(n + 1);
        if (dob.includes('%')) {
            dob = dob.split('%2F');
            var c = '';
            for (var a = 0; a < dob.length; a++) {
                c += dob[a] + '/';
            }
            c = c.substring(0, c.length - 1);
        } else {
            var c = dob;
        }
        var addr = arr[3];
        var n = addr.indexOf("=");
        addr = addr.substring(n + 1);
        addr = addr.split('+');
        var d = '';
        for (var a = 0; a < addr.length; a++) {
            d += addr[a] + ' ';
        }
        var num = arr[4];
        var n = num.indexOf("=");
        num = num.substring(n + 1);

        div.innerHTML = "<img src='http://2.gravatar.com/avatar/8b91904f96464928ad93807b5fa9a611'>";
        div.innerHTML += "<div id='detail'>First Name: " + fname + "</div>";
        div.innerHTML += "<div id='detail'>Last Name: " + lname + "</div>";
        div.innerHTML += "<div id='detail'>Number: " + num + "</div>";
        div.innerHTML += "<div id='detail'>Address: " + d + "</div>";
        div.innerHTML += "<div id='detail'>Birthday: " + c + "</div>";
        list.appendChild(div);
    }
}

function getNum() {
    var temp = window.location.search;
    temp = temp.substring(4);
    document.getElementById("num").value = temp;
}

function validateNumber() {
    var num = document.getElementById('ph').value;
    if (num == "") {
        alert('Enter Phone Number');
        return false;
    }
    return true;
}