<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="./resources/images/favicon.png">
    <link rel="stylesheet" href="./resources/fonts/stylesheet.css">
    <link rel="stylesheet" href="./resources/css/index.css">
    <link rel="stylesheet" href="./resources/css/documents.css">
    <link href="./resources/css/previewStyle.css" rel="stylesheet">
    <link href="./resources/css/select2.min.css" rel="stylesheet" />

    <title>Web Stream</title>
</head>

<body>
<div class="template-header" >
    <div class="container">
        <div class="header-title">
            WEB STREAM

            <span class="icon" onclick="reloadPage()">
        <svg width="25px" height="35px" class="ionicon" viewBox="0 0 512 512"><path d="M80 212v236a16 16 0 0016 16h96V328a24 24 0 0124-24h80a24 24 0 0124 24v136h96a16 16 0 0016-16V212" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="32"></path><path d="M480 256L266.89 52c-5-5.28-16.69-5.34-21.78 0L32 256M400 179V64h-48v69" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="32"></path></svg>
    </span>

        </div>
        <div class="nav-ctrl">
            <%--           --%>
            <div class="user-control">
                <div class="user-head"><!--open-->
                    <img id="user_image" src="./resources/assets/avatar-f.jpg" alt="">&nbsp&nbsp
                    <div id="signout_div">
                        <div class="user-name"><% out.print(session.getAttribute("uname")); %></div>
                        <div id="uname" style="display: none"><% session.getAttribute("uname");%></div>
                        <div id="designation" style="display: none"><% session.getAttribute("designation");%></div>
                        <div id="department" style="display: none"><% session.getAttribute("department");%></div>
                        <a href="./signout" class="logout-btn">Logout</a>
                    </div>


                </div>
            </div>
        </div>

    </div>
</div>

<div class="template-widget" id="main_header">
    <div class="container"id="main_body">
        <div class="template-title" style="display: flex">
            <h2>Checklist</h2>&nbsp&nbsp&nbsp
            <div class="marquee-container">
                <div class="marquee-content">
                    <p>Translation required if document is in the vernacular language.</p>
                    <p>Documents need to be tagged under the respective dropdown.</p>
                </div>
            </div>
        </div>
        <div class="template-body">
            <div class="template_primary" id="primary_template" >

            </div>
            <div class="grid" id="gridId">
                <div class="g-col-6">
                    <div class="input-row" id="first_row">


                        <label>Entity Name:  <span class="inp-value" id ="entity_value" style="display: none">ABCD</span></label>

                        <div class="input-group">
                            <input type="text" id="name" class="input-ctrl" >
                        </div>
                    </div>
                </div>
                <div class="g-col-6">
                    <div class="input-row" id="second_row">
                        <label >Customer-Type:  <span id ="custType" style="display: none"> ABCD </span></label>
                        <div class="input-group">
                            <select name="combobox" id="customer_type" class="select-ctrl" onchange="customerTypeSelection()">
                                <option id="first_value" value="" disabled selected>Select Customer Type</option>
                                <option value="NEW CUSTOMER-ACCOUNT OPENING">NEW CUSTOMER-ACCOUNT OPENING</option>
                                <option value="NEW CUSTOMER-ID CREATION">NEW CUSTOMER-ID CREATION</option>
                                <option value="EXISTING CUSTOMER-NEW ACCOUNT">EXISTING CUSTOMER-NEW ACCOUNT</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="g-col-6">
                    <div class="input-row" id="acc_row">
                        <label for="account_type" id="acc_lbl">Account-Type: <span id ="accType" style="display: none">ABCD </span></label>
                        <div class="input-group">

                            <select name="combobox"  id="account_type" class="select-ctrl" onchange="accountTypeSelection()">
                                <option value="" disabled selected >Select Account Type</option>
                                <option value="SAVINGS">SAVINGS ACCOUNT</option>
                                <option value="CURRENT">CURRENT ACCOUNT</option>
                                <option value="CURRENT SPECIAL SCHEME ACCOUNT">CURRENT SPECIAL SCHEME ACCOUNT</option>
                                <option value="SAVINGS SPECIAL SCHEME ACCOUNT">SAVINGS SPECIAL SCHEME ACCOUNT</option>


                            </select>
                        </div>
                    </div>
                </div>

                <div class="g-col-6">
                    <div class="input-row" id="third_row">
                        <label for="scheme_type" id="scheme_lbl">Scheme: <span id ="schemeType" style="display: none"> ABCD</span></label>
                        <div class="input-group">

                            <select name="combobox" class="select-ctrl" id="scheme_type">
                                <option id="SelectScheme" disabled selected>Select Scheme</option>
                            </select>

                        </div>
                    </div>
                </div>


                <div class="g-col-12 text-right">
                    <div class="button-row" id = "submit-btn">
                        <button class="primary-btn submit-btn" onclick="validation()">Proceed</button>

                    </div>
                </div>
            </div>

            <div class="grid">
                <div class="g-col-6" id="secondary">
                    <div class="input-row">

                        <label for="constitution"  id="const_lbl" style="display: none">Constitution  </label>
                        <div class="input-group">
                            <select name="combobox" class="select-ctrl" id="constitution" style="display: none" onchange="constitutionTypeSelection()">
                                <option id="select_constitution" >Select Constitution</option>

                            </select>
                        </div>
                    </div>
                </div>

                <div class="g-col-6" id="secondary_one">
                    <div class="input-row">
                        <label for="sub_constitution" id="sub_constitution_lbl" style="display: none">Sub-Constitution </label>
                        <div class="input-group">

                            <select name="combobox" class="select-ctrl" id="sub_constitution" style="display: none" onchange="subConstitutionTypeSelection()">
                                <option id="select_sub-constitution">Select Sub-Constitution</option>
                            </select>
                        </div>
                    </div>
                </div>

            </div>
            <div class="template-documents" id="documents" style="display: none">
                <div class="template-doc-title">
                    <h2>DOCUMENTS</h2>
                </div>
                <div class="accordion-list mb-15" id="mandatory_documents">
                    <div class="accordion-head">
                        <strong>MANDATORY DOCUMENTS</strong>

                    </div>

                    <div class="accordion-body">
                        <div class="accordion-article">
                            <div class="selectAll" id="selectAll" style="display:none">
                                <label id="select_container">
                                    <span class="select-all-text">Select All</span>&nbsp&nbsp&nbsp
                                    <input type="checkbox" class="manToggle" onclick="toggleAllCheckboxes()">
                                </label>
                            </div>
                            <div class="card" id="mand_documents"></div>



                        </div>

                    </div>

                </div>



                <div class="accordion-list mb-15" id="other_documents">
                    <div class="accordion-head">
                        <strong>KYC DOCUMENTS (Any Two Documents Required)</strong>

                    </div>
                    <div class="accordion-body">
                        <div class="accordion-article" >
                            <div class="card" id="othr_documents">

                            </div>


                        </div>
                    </div>
                </div>
                <div class="accordion-list mb-15" id="special_documents">
                    <div class="accordion-head">
                        <strong>SPECIAL DOCUMENTS</strong>

                    </div>
                    <div class="accordion-body" >
                        <div  class="accordion-article">
                            <div class="card" id="spl_documents">

                            </div>
                        </div>

                    </div>
                </div>
                <div class="accordion-list mb-15" id="other_points">
                    <div class="accordion-head">
                        <strong>OTHER POINTS</strong>

                    </div>
                    <div class="accordion-body" >
                        <div  class="accordion-article">
                            <div class="card" id="oth_points">

                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <div class="g-col-12 text-right">
            <div class="button-row" id = "preview-btn"  style="display: none">
                <button class="primary-btn submit-btn" onClick ="Modal()">Submit</button>
            </div>
        </div>


        &nbsp;
        &nbsp;
    </div>

</div>

<%--preview--%>
<div>

    <div class="previewtemplate-widget" id="preview_open" style="display: none">
        <div class="previewcontainer">
            <div class="previewtemplate-title">
                <h2>Preview</h2>
            </div>
            <div class="previewtemplate-body mb-15">

                <div class="previewgrid">
                    <div class="previewg-col-6">
                        <div class="previewcard" id="previewcard">
                            <div class="main">

                                <form>
                                    <div id="previewcontent">
                                        <h4>BASIC INFORMATION</h4>
                                        <div id="previewname">
                                            <span >ENTITY NAME</span>
                                            <span id ="previewentityName">:&nbsp;&nbsp;</span>

                                        </div>

                                        <div id="previewtype">
                                            <span >CUSTOMER TYPE</span>
                                            <span id ="previewcus_type">:&nbsp;&nbsp;</span>

                                        </div>

                                        <div id="previewacctype">
                                            <span >ACCOUNT TYPE</span>
                                            <span id ="previewacc_type">:&nbsp;&nbsp;</span>

                                        </div>
                                        <div id="previewSchemetype">
                                            <span >SCHEME</span>
                                            <span id ="previewScheme">:&nbsp;&nbsp;</span>

                                        </div>

                                        <div id="previewconstitution_div">
                                            <span >CONSTITUTION</span>
                                            <span id ="previewconstitution">:&nbsp;&nbsp;</span>

                                        </div>



                                        <div id="previewsub_constitution_div">
                                            <span >SUB-CONSTITUTION</span>
                                            <span id ="previewsub_constitution">:&nbsp;&nbsp;</span>

                                        </div>


                                    </div>
                                    <h3>DOCUMENTS</h3>
                                    <div id="previewdoc">


                                        <div id="previewMandatory_doc">

                                            <span >MANDATORY-DOCUMENTS</span>
                                            <span id ="previewMandatory_constitution"></span>


                                        </div>


                                        <div id="previewothers_doc">
                                            <span >OTHER-DOCUMENTS</span>
                                            <span id ="previewOther_constitution"></span>


                                        </div>


                                        <div id="previewspecial_doc" style="display: none">
                                            <span >SPECIAL-DOCUMENTS</span>
                                            <span id ="previewSpecial_constitution"></span>


                                        </div>

                                        <div id="approval_data">
                                            <span id="spanApp"></span>
                                        </div>
                                        <div id="previewotherpoints_doc" style="display: none">
                                            <span style="font-weight: bold"><u>OTHER POINTS</u></span>
                                            <span id ="previewother_pnts"></span>


                                        </div>
                                        <div>
                                            <p id="note_id">Note:</p>

                                            <div id="note_div">  <p>Translation required if document is in vernacular language.</p>
                                                <p>Documents needs to be tagged under respective dropdown.</p></div>
                                        </div>

                                    </div>



                                </form>


                            </div>
                        </div>
                    </div>
                </div>
                <div class="previewbutton-row">
                    <button class="previewprimary-btn submit-btn" onclick="print()">Download</button>
                    <button  class="previewsecondary-btn submit-btn"  onclick="back()">Back</button>
                </div>
            </div>

        </div>
    </div>

</div>


<script src="./resources/script/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./resources/script/index.js" type="text/javascript"></script>
<script src="./resources/script/document.js" type="text/javascript"></script>
<script src="./resources/script/select2.min.js"></script>
</body>
</html>
