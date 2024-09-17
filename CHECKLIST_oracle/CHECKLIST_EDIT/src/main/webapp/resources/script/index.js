let customerName = "";
let customerType = "";
let accountType = "";
let schemeType = "";
let constitutionType = "";
let subconstitutionType = "";
let IdCreation = false;
let schemeAccount = false;
let docArray = [];
let mandocarray = [];
let manArray = [];
let splArray = [];
let splDocumentArray = [];
let otherDocArray = [];
let manPreviewArray = [];
let otherPreviewArray = [];
let splPreviewArray = [];
let specialDocArray = "";
let manLength = 0;
let totalManToggle = 0;
let splLength = 0;
let totalsplToggle = 0;
let totalOtherToggle = 0;
let isWaver = false;
let splFlag = false;
let excep_data = "";
let otherFlag = false;
let otherPointsArray = [];
let otherPointsFlag = "false";


function getApi(api, callback) {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            callback(this.responseText);
        }
    }
    xhr.open('GET', api,);
    xhr.send('');
}
window.addEventListener("load", function () {
    var name = document.getElementById("uname").innerHTML;
    var department = document.getElementById("department").innerHTML;
    var designation = document.getElementById("designation").innerHTML;
    //console.log("name",name);

    if (name == "null" && department=="null" && designation =="null") {
        window.location.href = "/";
    }
});
function proceed() {

    var name = document.getElementById('name').value;
    var cus_type = document.getElementById('customer_type').value;
    var acc_type = document.getElementById('account_type').value;
    var scheme_type = document.getElementById('scheme_type').value;


    if (customerName != "" || customerType != "" || accountType != "" || schemeType != "") {
        document.getElementById('submit-btn').style.display = 'none';


        const details = document.querySelector("#primary_template");
        const main_details = document.querySelector("#gridId");
        var name_div = document.createElement("div");
        name_div.className = "grid view-widget";

        document.getElementById("gridId").style.display = 'none';
        if (cus_type == "NEW CUSTOMER-ID CREATION") {
            name_div.innerHTML = '<div class="g-col-6 view-list">' +
                'Entity Name:' + '<span id="entityResult">' + name + '</span>' + '</div>' +
                ' <div class="g-col-6 view-list">' + 'Customer Type: ' + '<span id="custResult">' + cus_type + '</span>' + '</div>'
        } else if ((acc_type == "CURRENT SPECIAL SCHEME ACCOUNT") || (acc_type == "SAVINGS SPECIAL SCHEME ACCOUNT")) {


            name_div.innerHTML = '<div class="g-col-6 view-list">' +
                'Entity Name:' + '<span id="entityResult">' + name + '</span>' + '</div>' +
                ' <div class="g-col-6 view-list">' + 'Customer Type: ' + '<span id="custResult">' + cus_type + '</span>' + '</div>' +
                ' <div class="g-col-6 view-list">' + 'Account Type: ' + '<span id="accResult">' + acc_type + '</span>' + '</div>' +
                ' <div class="g-col-6 view-list">' + 'Scheme:' + '<span id="schemeResult">' + scheme_type + '</span>' + '</div>'
        } else {
            name_div.innerHTML = '<div class="g-col-6 view-list">' +
                'Entity Name:' + '<span id="entityResult">' + name + '</span>' + '</div>' +
                ' <div class="g-col-6 view-list">' + 'Customer Type: ' + '<span id="custResult">' + cus_type + '</span>' + '</div>' +
                ' <div class="g-col-6 view-list">' + 'Account Type: ' + '<span id="accResult">' + acc_type + '</span>' + '</div>'
        }
        details.append(name_div);


        document.getElementById('custType').style.display = "inline-block"
        var custValue = document.getElementById('customer_type').value
        document.getElementById('custType').innerHTML = custValue;
        document.getElementById('customer_type').style.visibility = 'hidden';

        document.getElementById('accType').style.display = "inline-block"
        var accValue = document.getElementById('account_type').value
        document.getElementById('accType').innerHTML = accValue;
        document.getElementById('account_type').style.visibility = 'hidden';

        document.getElementById('schemeType').style.display = "inline-block"
        var schemeValue = document.getElementById('scheme_type').value
        document.getElementById('schemeType').innerHTML = schemeValue;
        document.getElementById('scheme_type').style.visibility = 'hidden';
    }

    document.getElementById("const_lbl").style.display = "inline-block";
    document.getElementById("constitution").style.display = "inline-block";

    document.getElementById("constitution").value = false;
    document.getElementById("sub_constitution").value = false;


}

function removeErrorSpan(errorSpanId) {
    var errorSpan = document.getElementById(errorSpanId);
    if (errorSpan) {
        errorSpan.remove();
    }
}


function validation() {

    if ($('.validate-text').length > 0) {
        $('.validate-text').remove();
    }

    //collecting the customername
    customerName = document.getElementById("name").value;

    document.getElementById("name").addEventListener("input", function () {
        removeErrorSpan("name_error");
    });

    document.getElementById("customer_type").addEventListener("change", function () {
        removeErrorSpan("cust_type_error");
    });

    document.getElementById("account_type").addEventListener("change", function () {
        removeErrorSpan("acc_type_error");
    });

    // Add an event listener to the scheme type select field (if applicable)

    document.getElementById("scheme_type").addEventListener("change", function () {
        removeErrorSpan("scheme_type_error");
    });


    if (IdCreation === true) {

        if (customerName != "" && customerType != "") {
            document.getElementById("secondary").style.display = "inline-block";
            document.getElementById("secondary_one").style.display = "inline-block";
            proceed();
        } else {

            if (customerName === "") {

                var span = document.createElement("span");
                span.id = "name_error";
                span.className = "validate-text";
                span.innerHTML = "Please enter customer name";
                var main = document.getElementById("first_row");
                main.appendChild(span);

            }
            if (customerType === "") {

                var span = document.createElement("span");
                span.id = "cust_type_error";
                span.className = "validate-text";
                span.innerHTML = "Please select customer type";
                var main = document.getElementById("second_row");
                main.appendChild(span);

            }
        }
    } else {
        accountType = document.getElementById("account_type").value;

        if (schemeAccount === true) {

            //collecting the schemeType
            schemeType = document.getElementById("scheme_type").value;

            if (customerName != "" && customerType != "" && accountType != "" && schemeType != "") {
                if (schemeType === "Select Scheme") {
                    var span = document.createElement("span");
                    span.className = "validate-text";
                    span.id = "scheme_type_error";
                    span.innerHTML = "";
                    span.innerHTML = "Please select scheme type";
                    var main = document.getElementById("third_row");
                    main.appendChild(span);
                } else {
                    document.getElementById("secondary").style.display = "inline-block";
                    document.getElementById("secondary_one").style.display = "inline-block";
                    proceed();
                }

            } else {
                if (customerName === "") {
                    span.id = "name_error";
                    var span = document.createElement("span");
                    span.className = "validate-text";
                    span.innerHTML = "Please enter customer name";
                    var main = document.getElementById("first_row");
                    main.appendChild(span);

                }
                if (customerType === "") {

                    var span = document.createElement("span");
                    span.className = "validate-text";
                    span.id = "cust_type_error";
                    span.innerHTML = "Please select customer type";
                    var main = document.getElementById("second_row");
                    main.appendChild(span);

                }
                if (accountType === "") {

                    var span = document.createElement("span");
                    span.className = "validate-text";
                    span.id = "acc_type_error";
                    span.innerHTML = "Please select account type";
                    var main = document.getElementById("acc_row");
                    main.appendChild(span);

                }

                if (schemeType === "") {

                    var span = document.createElement("span");
                    span.className = "validate-text";
                    span.id = "scheme_type_error";
                    span.innerHTML = "";
                    span.innerHTML = "Please select scheme type";
                    var main = document.getElementById("third_row");
                    main.appendChild(span);

                }

            }

        } else {
            if (customerName != "" && customerType != "" && accountType != "") {
                document.getElementById("secondary").style.display = "inline-block";
                document.getElementById("secondary_one").style.display = "inline-block";
                proceed();
            } else {

                if (customerName === "") {

                    var span = document.createElement("span");
                    span.className = "validate-text";
                    span.id = "name_error";
                    span.innerHTML = "Please enter customer name";
                    var main = document.getElementById("first_row");
                    main.appendChild(span);

                }
                if (customerType === "") {

                    var span = document.createElement("span");
                    span.className = "validate-text";
                    span.id = "cust_type_error";
                    span.innerHTML = "Please select customer type";
                    var main = document.getElementById("second_row");
                    main.appendChild(span);

                }
                if (accountType === "") {

                    var span = document.createElement("span");
                    span.className = "validate-text";
                    span.id = "acc_type_error";
                    span.innerHTML = "Please select account type";
                    var main = document.getElementById("acc_row");
                    main.appendChild(span);

                }

                if (schemeType === "") {

                    var span = document.createElement("span");
                    span.className = "validate-text";
                    span.id = "scheme_type_error";
                    span.innerHTML = "";
                    span.innerHTML = "Please select scheme type";
                    var main = document.getElementById("third_row");
                    main.appendChild(span);

                }

            }
        }

    }
    if (accountType.toUpperCase() == "CURRENT") {
        getApi("./api/getConstitutionData?accountType=" + accountType.toUpperCase() + "&customerType=-" + "&specialScheme=-", function (response) {
            splFlag = false;
            populateConstitution(response);
        });

    } else if (accountType.toUpperCase() == "SAVINGS") {
        getApi("./api/getConstitutionData?accountType=" + accountType.toUpperCase().toUpperCase() + "&customerType=-" + "&specialScheme=-", function (response) {
            splFlag = false;
            populateConstitution(response);
        });

    } else if (accountType.toUpperCase() == "CURRENT SPECIAL SCHEME ACCOUNT") {
        var selected_value = document.getElementById("scheme_type").value;

        getApi("./api/getConstitutionData?accountType=" + accountType.toUpperCase().toUpperCase() + "&customerType=-" + "&specialScheme=" + selected_value, function (response) {
            splFlag = true;
            populateConstitution(response);
        });


    } else if (accountType.toUpperCase() == "SAVINGS SPECIAL SCHEME ACCOUNT") {
        var selected_values = document.getElementById("scheme_type").value;

        getApi("./api/getConstitutionData?accountType=" + accountType.toUpperCase().toUpperCase() + "&customerType=-" + "&specialScheme=" + selected_values, function (response) {
            splFlag = true;
            populateConstitution(response);
        });


    } else if (customerType.toUpperCase() == "NEW CUSTOMER-ID CREATION") {
        getApi("./api/getConstitutionData?accountType=-" + "&customerType=" + customerType.toUpperCase() + "&specialScheme=-", function (response) {
            populateConstitution(response);
        });
    }


}

function customerTypeSelection() {
    document.getElementById("account_type").value = document.getElementById("first_value").value;
    customerType = document.getElementById("customer_type").value;
    if (customerType.toLowerCase() === "new customer-id creation") {
        document.getElementById("acc_lbl").style.display = "none"
        document.getElementById("acc_row").style.display = "none";
        document.getElementById("scheme_lbl").style.display = "none";
        document.getElementById("third_row").style.display = "none";
        document.getElementById("special_documents").style.display = "none";

        IdCreation = true;
    } else {
        document.getElementById("acc_lbl").style.display = "block";
        document.getElementById("acc_row").style.display = "block";
        IdCreation = false;
    }
    document.getElementById("secondary").style.display = "none";
    document.getElementById("secondary_one").style.display = "none";
}

function accountTypeSelection() {
    document.getElementById("scheme_type").options.length = 0;
    var scheme = document.getElementById("scheme_type");


    accountType = document.getElementById("account_type").value;
    if ((accountType === "CURRENT SPECIAL SCHEME ACCOUNT") || (accountType === "SAVINGS SPECIAL SCHEME ACCOUNT")) {
        // document.getElementById("scheme_type").value = document.getElementById("SelectScheme").value
        document.getElementById("scheme_lbl").style.display = "block";
        document.getElementById("third_row").style.display = "block";
        document.getElementById("special_documents").style.display = "flex";


        getApi("./api/getSchemes?sectionName=" + accountType, function (response) {


            populateScheme(response);

        });
        schemeAccount = true;
    } else {
        document.getElementById("scheme_lbl").style.display = "none";
        document.getElementById("third_row").style.display = "none";
        document.getElementById("special_documents").style.display = "none";
        schemeAccount = false;
    }
    document.getElementById("secondary").style.display = "none";
    document.getElementById("secondary_one").style.display = "none";
}


function populateScheme(response) {

    var strResponse = response;
    var scheme_new = document.getElementById("scheme_type");
    var splitStr = strResponse.split(",");

    let optn = document.createElement("option")

    optn.innerHTML = "Select Scheme";

    scheme_new.append(optn);

    for (let i = 0; i < splitStr.length; i++) {
        let optn_one = document.createElement("option")

        optn_one.innerHTML = splitStr[i];

        scheme_new.append(optn_one);


    }


}


function populateConstitution(response) {

    var strResponse = response;
    var splitStr = strResponse.split(",");
    var constitution = document.getElementById("constitution");

    for (let i = 0; i < splitStr.length; i++) {
        let optn = document.createElement("option");
        optn.innerHTML = splitStr[i];
        constitution.appendChild(optn);
    }
    document.getElementById("sub_constitution_lbl").style.display = "none";
    document.getElementById("sub_constitution").style.display = "none";
}


function constitutionTypeSelection() {

    document.getElementById("select_constitution").disabled = true;

    constitutionType = document.getElementById("constitution").value;

    document.getElementById("sub_constitution_lbl").style.display = "inline-block";
    document.getElementById("sub_constitution").style.display = "inline-block";
    if (IdCreation == true) {
        getApi("./api/getSubConstitutionData?constitution=" + constitutionType.toUpperCase() + "&accountType=-" + "&customerType=" + customerType.toUpperCase(), function (response) {
            document.getElementById("sub_constitution").options.length = 0;
            var sub_con = document.getElementById("sub_constitution");
            let opt = document.createElement("option");
            opt.innerHTML = "Select Sub-Constitution";
            opt.disabled = true;
            sub_con.appendChild(opt);
            sub_con.selectedIndex = 0;
            if (constitutionType == "SOLE PROPRIETORY") {
                otherFlag = true;
                document.getElementById("other_documents").style.display = "flex";
            } else {
                otherFlag = false;
                document.getElementById("other_documents").style.display = "none";
            }
            populateSubConstitution(response);
            document.getElementById("mand_documents").innerHTML = "";
            document.getElementById("othr_documents").innerHTML = "";
            document.getElementById("spl_documents").innerHTML = "";
        });
    } else {
        getApi("./api/getSubConstitutionData?constitution=" + constitutionType.toUpperCase() + "&accountType=" + accountType.toUpperCase(), function (response) {
            document.getElementById("sub_constitution").options.length = 0;
            var sub_con = document.getElementById("sub_constitution");
            let opt = document.createElement("option");
            opt.innerHTML = "Select Sub-Constitution";
            opt.disabled = true;
            sub_con.appendChild(opt);
            sub_con.selectedIndex = 0;
            if (constitutionType == "SOLE PROPRIETORY") {
                otherFlag = true;
                document.getElementById("other_documents").style.display = "flex";
            } else {
                otherFlag = false;
                document.getElementById("other_documents").style.display = "none";
            }
            populateSubConstitution(response);
            document.getElementById("mand_documents").innerHTML = "";
            document.getElementById("othr_documents").innerHTML = "";
            document.getElementById("spl_documents").innerHTML = "";
        });
    }
    var selectAllDiv = document.getElementById("selectAll");
    var checkbox = selectAllDiv.querySelector("input[type='checkbox']");
    if(checkbox.checked==true){
        checkbox.checked = false;
        checkbox.parentElement.querySelector('.select-all-text').textContent = 'Select All';
    }
    var pointsDiv = document.getElementById("oth_points");

    if (pointsDiv) {

        pointsDiv.innerHTML = "";
    }

}

function populateSubConstitution(response) {

    var strResponse = response;
    var splitStr = strResponse.split(",");
    var sub_constitution = document.getElementById("sub_constitution");
    for (let i = 0; i < splitStr.length; i++) {
        let optn = document.createElement("option");
        optn.innerHTML = splitStr[i];
        sub_constitution.appendChild(optn);
    }

}

function subConstitutionTypeSelection() {

    document.getElementById("documents").style.display = "block";
    subconstitutionType = document.getElementById("sub_constitution").value;
    document.getElementById("preview-btn").style.display = "inline-block"
    // populateDocuments();
    document.getElementById("mand_documents").innerHTML = "";
    document.getElementById("othr_documents").innerHTML = "";
    document.getElementById("spl_documents").innerHTML = "";

    manArray = [];
    otherPreviewArray = [];
    splArray = [];


    populateDocuments();
    document.getElementById("selectAll").style.display = "flex";
    document.getElementById("selectAll").style.display = "flex";
    getApi("./api/getOtherPointsData?subConstitution="+subconstitutionType.toUpperCase(), function (response) {
        populateOtherPoints(response);
    });

    var selectAllDiv = document.getElementById("selectAll");
    var checkbox = selectAllDiv.querySelector("input[type='checkbox']");
    if(checkbox.checked==true){
        checkbox.checked = false;
        checkbox.parentElement.querySelector('.select-all-text').textContent = 'Select All';
    }

    var oth_doc = document.getElementById("oth_points");
    oth_doc.innerHTML="";
}

function populateDocuments() {

    schemeType = document.getElementById("scheme_type").value;
    if (accountType == "CURRENT SPECIAL SCHEME ACCOUNT") {

        getApi("./api/getDocumentsData?customerType=" + customerType.toUpperCase() + "&accountType=" + accountType.toUpperCase() + "&constitutionType=" + constitutionType.toUpperCase() + "&subConstitution=" + subconstitutionType.toUpperCase() + "&schemeType=" + schemeType.toUpperCase(), function (response) {


            mandatoryDocuments(response);

        });

    } else if (accountType == "SAVINGS SPECIAL SCHEME ACCOUNT") {
        getApi("./api/getDocumentsData?customerType=" + customerType.toUpperCase() + "&accountType=" + accountType.toUpperCase() + "&constitutionType=" + constitutionType.toUpperCase() + "&subConstitution=" + subconstitutionType.toUpperCase() + "&schemeType=" + schemeType.toUpperCase(), function (response) {

            mandatoryDocuments(response);
        });

    } else if (customerType.toUpperCase() == "NEW CUSTOMER-ID CREATION") {

        getApi("./api/getDocumentsData?customerType=" + customerType.toUpperCase() + "&accountType=-" + "&constitutionType=-" + "&subConstitution=" + subconstitutionType.toUpperCase() + "&schemeType=-", function (response) {


            mandatoryDocuments(response);
        });


    } else {
        getApi("./api/getDocumentsData?customerType=" + customerType.toUpperCase() + "&accountType=" + accountType.toUpperCase() + "&constitutionType=-" + "&subConstitution=" + subconstitutionType.toUpperCase() + "&schemeType=-", function (response) {


            mandatoryDocuments(response);
        });
    }


}

function reset() {
    location.reload();
}

function oth(otherDocuments) {
    var othr_documents = document.getElementById("othr_documents");

    for (let i = 0; i < otherDocuments.length; i++) {
        let prime_card = document.createElement("div");
        prime_card.classList.add('cardList');
        let top_card = document.createElement("div");
        top_card.className = "other_card";
        let head = document.createElement("h");
        head.id = "heading";
        let toggleInput = document.createElement("div");
        let span = document.createElement("span");

        getApi("api/getChecklistData?documentName=" + otherDocuments[i].toUpperCase() + "&subConstitution=" + subconstitutionType.toUpperCase()+"&customerType=-", function (response) {
            var splitStr1 = response.split("+");
            var main = document.createElement("div");
            main.className = "mainDiv"
            var ul = document.createElement("ul")
            ul.className = "points"
            for (let j = 0; j < splitStr1.length; j++) {
                head.innerHTML = otherDocuments[i];

                toggleInput.innerHTML = '<input type="checkbox"  id=anser_1_' + i + '  onclick="checkControl(this)" class="toggleClass">'

                span.id = "label_1_" + i;
                var li = document.createElement("li");
                li.innerHTML = convertToSentenceCase(splitStr1[j]);
                ul.append(li);

            }

            top_card.append(head, toggleInput, span);
            prime_card.append(top_card, ul);

            // Add the click event to the toggleInput element
            toggleInput.addEventListener("click", function () {
                var contentElement = ul; // Get the corresponding checklist ul element
                if (contentElement.style.display === "none" || contentElement.style.display === "") {
                    contentElement.style.display = "block";
                } else {
                    contentElement.style.display = "none";
                }
            });



        });

        othr_documents.append(prime_card);


    }
}

function mandToggle(m) {
    m.classList.add('man_check');
    var id = m.id;
    var split = id.split("_");
    var num = split[1];

    var manValue = document.getElementById("mlist_" + num).innerText;
    const parentElement = m.parentElement; // Get the parent element of the checkbox
    const manContentDiv = parentElement.nextElementSibling; // Get the next sibling element (man_content div)


    if (m.checked) {
        if (manValue && !manArray.includes(manValue)) {
            manArray.push(manValue);
            totalManToggle=manArray.length;
        }
        manContentDiv.style.display = 'block';

    } else {

        m.classList.remove('man_check');
        var index = manArray.indexOf(manValue);
        if (index !== -1 &&manArray.includes(manValue)) {
            manArray.splice(index, 1);
            totalManToggle=manArray.length;
        }
        manContentDiv.style.display = 'none';
    }

    m.classList.add('active-check');

}

function splToggle(t) {
    t.classList.add('splCheck_');
    var id = t.id;
    var split = id.split("_");
    var num = split[1];

    var splValue = document.getElementById("spldoc_" + num).innerText;
    if (t.checked) {

        splArray.push(splValue);
    } else {

        t.classList.remove('splCheck_');
        var index = splArray.indexOf(splValue);
        if (index !== -1) {
            splArray.splice(index, 1);
        }
    }
    totalsplToggle = 0;
    t.classList.add('active-check');
    let splCtrl = document.querySelectorAll('.splToggle');

    for (var i = 0; i < splCtrl.length; i++) {
        if (splCtrl[i].checked) {
            totalsplToggle = totalsplToggle + 1;

        }

    }

}


function checkControl(c) {
    if (c.checked) {
        c.classList.add('other_check');
    } else {
        c.classList.remove('other_check');
    }
    c.classList.add('active-check');

    let toggleCtrl = document.querySelectorAll('.toggleClass');
    totalOtherToggle = 0;
    for (var i = 0; i < toggleCtrl.length; i++) {
        if (toggleCtrl[i].checked) {
            totalOtherToggle = totalOtherToggle + 1;
        }
    }

    if (totalOtherToggle > 1) {
        toggleCtrl.forEach(function (checkbox) {
            if (!checkbox.checked) {
                checkbox.disabled = true;
                let div = document.createElement('div');
                div.id = 'toggle_error'

                div.className = 'previewtoast-row previewsuccess';
                div.innerHTML = 'Only two documents is required';
                document.body.append(div);
                setTimeout(function () {

                    document.getElementById('toggle_error').remove();
                }, 3000)
            }
        });
    } else {
        toggleCtrl.forEach(function (checkbox) {
            checkbox.disabled = false;
        });
    }

}

function mandatoryDocuments(response) {

    if (response.includes("&&")) {
        var checklistUrl;
        splitedStr = response.split('&&');
        var mandDocuments = splitedStr[0];
        var otherDocuments = splitedStr[1];
        var mandatoryDocuments = mandDocuments.split('+')
        var otherDocuments = otherDocuments.split('+')


        document.getElementById("mandatory_documents").style.display = "flex";
        document.getElementById("other_documents").style.display = "flex";
        // document.getElementById("other_documents").style.display="inline-block";
        var man_documents = document.getElementById("mand_documents");
        const mand_content = document.createElement("div");
        mand_content.className = "mand_content";
        let mListRow = document.createElement("div");
        mListRow.classList.add('m-list-row');
        for (let i = 0; i < mandatoryDocuments.length; i++) {
            // let input = document.createElement("input");
            // input.type="checkbox";
            let toggleInput = document.createElement("div");
            let mList = document.createElement("div");
            mList.classList.add('m-list');
            mList.id = 'mlist_' + i + '';
            mList.innerHTML = mandatoryDocuments[i];
            toggleInput.innerHTML = '<input type="checkbox" id=manCheck_' + i + ' onclick="mandToggle(this)" class="manToggle">';

            if(mandatoryDocuments[i] == "AOF"){
                checklistUrl="api/getChecklistData?documentName=" + mandatoryDocuments[i].toUpperCase() + "&subConstitution=" + subconstitutionType.toUpperCase()+"&customerType="+customerType.toUpperCase();
            }else{
                checklistUrl="api/getChecklistData?documentName=" + mandatoryDocuments[i].toUpperCase() + "&subConstitution=" + subconstitutionType.toUpperCase()+"&customerType=-";
            }

            getApi(checklistUrl, function (response) {
                var content = document.createElement("div")
                content.className = "man_content"
                var splitStr = response.split("+");
                let ul = document.createElement("ul");
                for (let j = 0; j< splitStr.length; j++) {
                    let list = document.createElement("li");
                    let b = document.createElement("br");

                    list.innerHTML = convertToSentenceCase(splitStr[j]);
                    ul.appendChild(list);
                }


                if (mandatoryDocuments[i] == "AOF") {

                    content.append(ul);
                    mListRow.insertBefore(content, mListRow.firstChild);
                    mListRow.insertBefore(toggleInput, mListRow.firstChild);
                    mListRow.insertBefore(mList, mListRow.firstChild);


                } else {

                    mListRow.append(mList, toggleInput);
                    content.append(ul);
                    mListRow.appendChild(content);
                }


            });

        }
        manLength = mandatoryDocuments.length;
        man_documents.append(mListRow);

        mandocarray = mandatoryDocuments;
        var br = document.createElement("br");
        man_documents.appendChild(br);
        otherDocArray = otherDocuments;


        oth(otherDocuments);


    } else {
        var checklistUrl;
        var mandatoryDocuments = response.split("+")
        document.getElementById("mandatory_documents").style.display = "flex";
        var man_documents = document.getElementById("mand_documents");
        const mand_content = document.createElement("div");
        mand_content.className = "mand_content";
        let mListRow = document.createElement("div");
        mListRow.classList.add('m-list-row');
        for (let i = 0; i < mandatoryDocuments.length; i++) {
            // let input = document.createElement("input");
            // input.type="checkbox";
            let toggleInput = document.createElement("div");
            let mList = document.createElement("div");
            mList.classList.add('m-list');
            mList.id = 'mlist_' + i + '';
            mList.innerHTML = mandatoryDocuments[i];
            toggleInput.innerHTML = '<input type="checkbox" id=manCheck_' + i + ' onclick="mandToggle(this)" class="manToggle">';

            if(mandatoryDocuments[i] == "AOF"){
                checklistUrl="api/getChecklistData?documentName=" + mandatoryDocuments[i].toUpperCase() + "&subConstitution=" + subconstitutionType.toUpperCase()+"&customerType="+customerType.toUpperCase();
            }else{
                checklistUrl="api/getChecklistData?documentName=" + mandatoryDocuments[i].toUpperCase() + "&subConstitution=" + subconstitutionType.toUpperCase()+"&customerType=-";
            }
            getApi(checklistUrl, function (response) {
                var content = document.createElement("div")
                content.className = "man_content"
                var splitStr = response.split("+");
                let ul = document.createElement("ul");
                for (let i = 0; i < splitStr.length; i++) {
                    let list = document.createElement("li");
                    let b = document.createElement("br");

                    list.innerHTML = convertToSentenceCase(splitStr[i]);

                    ul.appendChild(list);

                }
                if (mandatoryDocuments[i] == "AOF") {


                    content.append(ul);
                    mListRow.insertBefore(content, mListRow.firstChild);
                    mListRow.insertBefore(toggleInput, mListRow.firstChild);
                    mListRow.insertBefore(mList, mListRow.firstChild);

                } else {
                    mListRow.append(mList, toggleInput);
                    content.append(ul)
                    mListRow.appendChild(content);
                }

            });



        }
        manLength = mandatoryDocuments.length;
        man_documents.append(mListRow);


        mandocarray = mandatoryDocuments;
        var br = document.createElement("br");
        man_documents.appendChild(br);
        document.getElementById("other_documents").style.display = "none";

    }

    if ((accountType.toUpperCase() == "SAVINGS SPECIAL SCHEME ACCOUNT") || (accountType.toUpperCase() == "CURRENT SPECIAL SCHEME ACCOUNT")) {


        splLength = 0;
        getApi("./api/getSchemes?sectionName=" + schemeType.toUpperCase(), function (response) {

            if (response.includes("&&")) {


                var splitStr = response.split('&&');


                document.getElementById("spl_documents").style.display = "inline-block";
                var specl_doc = document.getElementById("spl_documents");


                for (let i = 0; i < splitStr.length; i++) {
                    let toggleInput = document.createElement("div");
                    let div1 = document.createElement("div");
                    toggleInput.innerHTML = '<input type="checkbox" id=splCheck_' + i + ' onclick="splToggle(this)" class="splToggle">';
                    let lbl = document.createElement("label");
                    lbl.style.fontWeight = "bold";
                    lbl.id = 'spldoc_' + i;
                    let br = document.createElement("br");
                    lbl.innerHTML = splitStr[i];

                    div1.appendChild(lbl);
                    div1.appendChild(toggleInput);
                    div1.appendChild(br);
                    specl_doc.append(div1);

                }

                splLength = splitStr.length;
                docArray = splitStr;

            } else {

                splLength = 1;
                let toggleInput = document.createElement("div");
                document.getElementById("spl_documents").style.display = "inline-block";
                var spcl_doc = document.getElementById("spl_documents");
                toggleInput.innerHTML = '<input type="checkbox" id="splCheck_0" onclick="splToggle(this)" class="splToggle">'
                let lbl = document.createElement("label");
                lbl.id = 'spldoc_0';
                let br = document.createElement("br");
                lbl.innerHTML = response;
                spcl_doc.append(lbl, toggleInput);
                spcl_doc.appendChild(br);


            }


        });


    }
}

function otherPreview() {
    otherPreviewArray = [];
    var activeOnes = document.querySelectorAll('.other_check');
    var otherPreviewSet = new Set();

    activeOnes.forEach(function (element) {
        var parentDiv = element.parentElement;
        var grandParentDiv = parentDiv.parentElement.parentElement;
        var hTag = grandParentDiv.querySelector('h');

        if (hTag) {
            otherPreviewSet.add(hTag.innerText);
        }
    });

    otherPreviewArray = Array.from(otherPreviewSet);

}

function manPreview() {
    manPreviewArray = [];
    var manActiveOnes = document.querySelectorAll('.man_check');
    var manPreviewSet = new Set();

    manActiveOnes.forEach(function (element) {
        var parentManDiv = element.parentElement;

    });

    manPreviewArray = Array.from(manPreviewSet);


}

function Modal() {

    if (splFlag == true) {
        if (otherFlag == true) {

            if (manLength == totalManToggle && splLength == totalsplToggle && totalOtherToggle == 2) {
                manPreview()
                otherPreview();
                isWaver = false;

                mainModal();


            } else {
                manPreview()
                otherPreview();
                isWaver = true;

                waiverModal();


            }

        } else if (otherFlag == false) {
            if (manLength == totalManToggle && splLength == totalsplToggle) {
                isWaver = false;
                manPreview()
                mainModal();


            } else {

                isWaver = true;
                manPreview()
                waiverModal();


            }

        }

    } else if (splFlag == false) {
        if (otherFlag == true) {
            if (manLength == totalManToggle && totalOtherToggle == 2) {
                otherPreview();
                isWaver = false;
                manPreview()
                mainModal();


            } else {
                manPreview()
                otherPreview();
                isWaver = true;

                waiverModal();


            }
        } else if (otherFlag == false) {
            if (manLength == totalManToggle) {
                isWaver = false;
                manPreview()
                mainModal();


            } else {

                isWaver = true;
                manPreview()
                waiverModal();


            }

        }

    }


}


function remModal() {
    document.querySelector('#mainModal').remove();
}


function remSubModal() {
    document.querySelector('#subModal').remove();

}


function preview() {

    let subBtn = document.getElementById("main_header");
    subBtn.style.display = "none";


    document.querySelector('#mainModal').remove();
    let main_head = document.getElementById("main_header");
    let main_body = document.getElementById("main_body");
    document.getElementById('previewMandatory_constitution').innerHTML = "";
    document.getElementById('previewOther_constitution').innerHTML = "";
    document.getElementById('previewSpecial_constitution').innerHTML = "";
    document.getElementById('previewother_pnts').innerHTML = "";

    document.getElementById("preview_open").style.display = "flex";

    document.getElementById('previewentityName').innerText = document.getElementById("name").value;
    document.getElementById('previewcus_type').innerText = document.getElementById("customer_type").value;
    if(customerType === "NEW CUSTOMER-ID CREATION"){
        document.getElementById("previewacctype").style.display = "none";

    }
    else{
        document.getElementById('previewacc_type').innerHTML = document.getElementById("account_type").value;


    }    if (schemeAccount) {
        document.getElementById('previewScheme').innerHTML = document.getElementById("scheme_type").value;
    } else {
        document.getElementById("previewSchemetype").style.display = "none";
    }

    document.getElementById('previewconstitution').innerText = document.getElementById("constitution").value;
    document.getElementById('previewsub_constitution').innerText = document.getElementById("sub_constitution").value;
    // document.getElementById('previewMandatory_constitution').innerHTML=mandocarray
    let ul = document.createElement("ul");
    for (let i = 0; i < manArray.length; i++) {
        let list = document.createElement("li");
        list.innerHTML = manArray[i];
        ul.appendChild(list);
    }
    if (manArray.length > 0) {
        var prMan = document.getElementById('previewMandatory_constitution');
        prMan.append(ul);
    } else {
        var prMan = document.getElementById('previewMandatory_constitution');
        prMan.innerText = "NO DOCUMENTS AVAILABLE"
    }


    document.getElementById('previewsub_constitution').innerText = document.getElementById("sub_constitution").value;


    if (constitutionType === "SOLE PROPRIETORY") {
        document.getElementById('previewothers_doc').style.display = "grid";
        document.getElementById('previewothers_doc').style.gridTemplateColumns = "repeat(2, 1fr)";
        otherFlag = true;
        var showSpecial = document.getElementById('previewothers_doc');
        let othDoc = document.createElement("ul");
        for (let i = 0; i < otherPreviewArray.length; i++) {
            let list_oth = document.createElement("li");
            list_oth.innerHTML = otherPreviewArray[i];
            othDoc.appendChild(list_oth);
        }
        if (otherPreviewArray.length > 0) {
            var showOther = document.getElementById('previewOther_constitution');
            showOther.append(othDoc);
        } else {
            var showOther = document.getElementById('previewOther_constitution');
            showOther.innerText = "NO DOCUMENTS AVAILABLE"
        }

    } else {
        otherFlag = false;
        document.getElementById('previewothers_doc').style.display = "none";


    }


    if ((accountType.toUpperCase() == "SAVINGS SPECIAL SCHEME ACCOUNT") || (accountType.toUpperCase() == "CURRENT SPECIAL SCHEME ACCOUNT")) {
        var showSpecial = document.getElementById('previewspecial_doc');
        if (splArray.length > 0) {
            var schemeSpl = document.getElementById("previewSpecial_constitution");
            showSpecial.style.display = "grid";
            let specialDoc = document.createElement("ul");
            for (let x = 0; x < splArray.length; x++) {
                let list_special = document.createElement("li");
                list_special.innerHTML = splArray[x];
                specialDoc.appendChild(list_special);
            }
            schemeSpl.append(specialDoc);
        } else {

            var schemeSpl = document.getElementById("previewSpecial_constitution");
            showSpecial.style.display = "grid";

            schemeSpl.innerHTML = " NO DOCUMENTS AVAILABLE";

        }

    }

    let label = document.createElement('span');
    label.id = "exception"
    // label.classList.add('check-label');

    label.innerHTML = "Documents are incomplete to open the account, please take prior concurrence from Accounts Service Division.";
    excep_data = label.innerHTML;


    var br1=document.createElement("br");

    if(otherPointsFlag==="false"){
        document.getElementById('previewotherpoints_doc').style.display = "none";
    }else{
        let otherul= document.createElement("ol");
        document.getElementById('previewotherpoints_doc').style.display = "grid";
        var otherpts = document.getElementById("previewother_pnts");
        otherul.id="other_points_ul"
        for (let l= 0; l < otherPointsArray.length; l++) {
            let list_othr = document.createElement("li");
            list_othr.innerHTML = otherPointsArray[l];
            otherul.appendChild(list_othr);
        }
        otherpts.append(br1);
        otherpts.append(otherul);
    }



    if (isWaver == true) {
        var element = document.getElementById("spanApp");
        element.style.display="flex";
       element.innerHTML = excep_data;

    } else {
        var element = document.getElementById("spanApp");
        element.style.display="none";
    }

}

function back() {
    document.getElementById("preview_open").style.display = "none";
    document.getElementById("main_header").style.display = "flex";


}

function mainModal() {
    var modalWidget = document.createElement('div');
    modalWidget.classList.add('modal-widgrt');

    modalWidget.classList.add('open');
    modalWidget.id = "mainModal"
    var modalRow = document.createElement('div');
    modalRow.classList.add('modal-row');
    let h2 = document.createElement('h2');
    let p = document.createElement('p');
    p.classList.add('mb-15');
    p.innerHTML = "    Do you want to continue?    ";
    var modalSumbit = document.createElement('div');
    modalSumbit.classList.add('button-row');
    var btn = document.createElement('button');
    btn.classList.add('primary-btn');
    btn.id = "cancel"
    btn.innerHTML = "No"
    btn.setAttribute('onclick', 'remModal()');
    var btnCnfm = document.createElement('button');
    btnCnfm.classList.add('secondary-btn');
    btnCnfm.innerHTML = "Yes"
    btnCnfm.setAttribute('onclick', 'preview()');

    modalSumbit.append(btnCnfm, btn);

    modalRow.append(h2, p, modalSumbit);
    modalWidget.append(modalRow);
    document.body.appendChild(modalWidget);
}


function waiverModal() {
    var modalWidget = document.createElement('div');
    modalWidget.classList.add('modal-widgrt');

    modalWidget.classList.add('open');
    modalWidget.id = "mainModal"
    var modalRow = document.createElement('div');
    modalRow.classList.add('modal-row');
    let h2 = document.createElement('h2');
    let p = document.createElement('p');
    p.classList.add('mb-15');
    p.innerHTML = "  Waver signature should be obtained.  Do you want to continue?    ";
    var modalSumbit = document.createElement('div');
    modalSumbit.classList.add('button-row');
    var btn = document.createElement('button');
    btn.classList.add('primary-btn');
    btn.id = "cancel"
    btn.innerHTML = "No"
    btn.setAttribute('onclick', 'remModal()');
    var btnCnfm = document.createElement('button');
    btnCnfm.classList.add('secondary-btn');
    btnCnfm.innerHTML = "Yes"
    btnCnfm.setAttribute('onclick', 'preview()');

    modalSumbit.append(btnCnfm, btn);

    modalRow.append(h2, p, modalSumbit);
    modalWidget.append(modalRow);
    document.body.appendChild(modalWidget);
}

function print() {

    var designation=document.getElementById("designation").innerText;
    var uname=document.getElementById("uname").innerText;
    var department=document.getElementById("department").innerText;


    getApi("./api/logChecklistData?username="+ uname+"&designation="+designation+"&department="+department, function (response) {

    });


        var previewcardContent = document.getElementById("previewcard").innerHTML;


        // Open print preview
        var printWindow = window.open("", "_blank");
        var entity_name = document.getElementById("previewentityName").innerText;
        printWindow.document.write("<html><head><title>" + entity_name + "</title>");

        // Include CSS file
        printWindow.document.write("<link rel='stylesheet' type='text/css' href='./resources/css/print.css'>");
        printWindow.document.write(
            "<style>@media print { #previewcontent {  display: grid;row-gap: 10px; } }\n" +
            "@media print {\n" +
            "    .previewcard {\n" +
            "        display: block;\n" +
            "        padding: 1.5em;\n" +
            "        background-color: #e3efff;\n" +
            "        border: solid 1px #e0ebf9;\n" +
            "        border-radius: 20px;\n" +
            "        transition: ease-in-out .4s;\n" +
            "    }\n" +
            "}\n" + "@media print {\n" +
            "    .previewcard h3 { {\n" +
            "        color: var(--text-color);\n" +
            "        font-size: 16px;\n" +
            "        font-family: 'robotomedium';\n" +
            "        margin-bottom: 20px;\n" +
            "        margin-top: 30px;\n" +
            "        text-decoration: underline;\n" +
            "    }\n" +
            "}\n" +
            "@media print {#previewname {\n" +
            "    display: grid;\n" +
            "    grid-template-columns: repeat(2, 1fr);\n" +
            "}}\n" +
            "@media print {#previewtype {\n" +
            "    display: grid;\n" +
            "    grid-template-columns: repeat(2, 1fr);\n" +
            "}}\n" +
            "\n" +
            "@media print {#previewacctype {\n" +
            "    display: grid;\n" +
            "    grid-template-columns: repeat(2, 1fr);\n" +
            "}}\n" +
            "\n" +
            "@media print {#previewconstitution_div {\n" +
            "    display: grid;\n" +
            "    grid-template-columns: repeat(2, 1fr);\n" +
            "}}\n" +
            "@media print {\n" +
            "    #previewsub_constitution_div {\n" +
            "        display: grid;\n" +
            "        grid-template-columns: repeat(2, 1fr);\n" +
            "    }\n" +
            "}@media print { #previewSchemetype {\n" +
            "    display: grid;\n" +
            "    grid-template-columns: repeat(2, 1fr);\n" +
            "}}" +
            "\n" +
            "@media print {#previewothers_doc{\n" +
            "    display: grid;\n" +
            "    grid-template-columns: repeat(2, 1fr)\n" +
            "}}\n" +
            "@media print {#previewMandatory_doc{\n" +
            "    display: grid;\n" +
            "    grid-template-columns: repeat(2, 1fr)\n" +
            "}}\n" +
            "@media print {#previewspecial_doc{\n" +
            "    display: grid;\n" +
            "    grid-template-columns: repeat(2, 1fr)\n" +
            "}}\n" +
            "@media print {#previewcontent {\n" +
            "    display: grid;\n" +
            "    row-gap: 10px;\n" +
            "}}\n" +
            "@media print {#previewdoc{\n" +
            "    display: grid;\n" +
            "    row-gap: 10px;\n" +
            "}}\n" +
            "@media print {h4{\n" +
            "    text-decoration: underline;\n" +
            "}" + "@media print {h3{\n" +
            "    text-decoration: underline;\n" +
            "}" +
            "@media print {ul {\n" +
            "    margin: 0;\n" +
            "    padding:0;\n" +
            "    list-style-type: disclosure-closed;\n" +
            "}}\n" +
            "@media print{#note_id {\n" +
            "       font-weight: bold;\n" +
            "}}\n" +
            "@media print{#previewotherpoints_doc #other_points_ul  {\n" +
            "       list-style-type: disc;\n" +
            "margin-left: 30px;\n" +
            "}}\n" +
            "@media print{#spanApp {\n" +
            "       font-weight: bold;\n" +
            "    font-size: 20px;\n" +
            "}}</style>"
        );

        printWindow.document.write("</head><body>");
        printWindow.document.write(previewcardContent);
        printWindow.document.write("</body></html>");
        printWindow.document.close();

        printWindow.print();



}
function reloadPage() {
    window.location.reload();
}
function toggleAllCheckboxes() {
    const selectAllCheckbox = document.querySelector('.selectAll input');
    const checkboxes = document.querySelectorAll('.manToggle');
    var manContentElements = document.getElementsByClassName("man_content");

    checkboxes.forEach(checkbox => {
        if (checkbox !== selectAllCheckbox) {
            checkbox.checked = selectAllCheckbox.checked;

            if (selectAllCheckbox.checked) {
                checkbox.classList.add('active-check', 'man_check');
                checkbox.classList.add('active-check', 'man_check');
                manArray = mandocarray.slice();
                totalManToggle=manArray.length;

            } else {
                checkbox.classList.remove('active-check', 'man_check');
                checkbox.classList.remove('man_check');
                manArray=[];
                totalManToggle=0;
            }

        }
    });

    if (selectAllCheckbox.checked) {
        selectAllCheckbox.parentElement.querySelector('.select-all-text').textContent = 'Deselect All';
        for (var i = 0; i < manContentElements.length; i++) {
            var manContentElement = manContentElements[i];
            if (manContentElement.style.display === "none" || manContentElement.style.display === "") {
                manContentElement.style.display = "flex";
            }
        }
    } else {
        selectAllCheckbox.parentElement.querySelector('.select-all-text').textContent = 'Select All';
        for (var i = 0; i < manContentElements.length; i++) {
            var manContentElement = manContentElements[i];
            manContentElement.style.display = "none";
        }
    }

}

// Function to convert a string to sentence case
function convertToSentenceCase(str) {
    return str.toLowerCase().replace(/(^|\s)\S/g, (char) => char.toUpperCase());
}


function populateOtherPoints(response){


    if(response=="false"){

        document.getElementById("other_points").style.display="none";

    }else{
        document.getElementById("other_points").style.display="block";
        let toggleInput = document.createElement("div");
        var oth_doc = document.getElementById("oth_points");
        toggleInput.innerHTML = '<input type="checkbox" id="othr_points_check" onclick="otherpointsCollection()" class="splToggle">'
        oth_doc.appendChild(toggleInput);
        if(response.includes('+')){
            otherPointsArray=[];
            otherPointsArray=response.split('+');
            let ul = document.createElement("ul");
            for(let j=0;j<otherPointsArray.length;j++){
                let li = document.createElement("li");
                li.id = 'othpoints_j';
                li.style.marginLeft="10px";
                let br = document.createElement("br");
                li.innerHTML = convertToSentenceCase(otherPointsArray[j]);
                ul.append(li);
                oth_doc.appendChild(ul);
            }

        }else{
            otherPointsArray=[];
            otherPointsArray.push(response);
            console.log("hi");
            let li = document.createElement("li");
            let ul = document.createElement("ul");
            li.id = 'othpoints_0';
            li.style.marginLeft="10px";
            li.innerHTML = convertToSentenceCase(response);
            ul.appendChild(li);
            oth_doc.append(ul);
        }
    }
}
function otherpointsCollection() {
    var othra1=document.getElementById("othr_points_check");
    if(othra1.checked){
        otherPointsFlag="true";
    }else{
        otherPointsFlag="false";
        document.getElementById("previewotherpoints_doc").style.display="none";
    }

}
function preventBack(){
    window.history.forward()}
setTimeout(preventBack(),0);
window.onunload=function(){null;};
window.onbeforeload=function(){null;};