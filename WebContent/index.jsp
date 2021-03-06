<%@page import="asst.MapLanguagesToTables" %>
<HTML xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="en">
<HEAD>
<!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-180864298-1"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-180864298-1');
</script>
<meta http-equiv="Content-type" content="text/html;charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<TITLE>
Bible Corpus
</TITLE>

<!-- index.html

   Copyright (c) 2020 by Advanced Systems and Software Technologies.
   All Rights Reserved

-->

<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
<script type="text/javascript" src="javascript/autosuggest.js"></script>
<script type="text/javascript" src="javascript/bookNames.js"></script>
<!-- jQuery (necessary for Bootstrap’s JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js">
</script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="javascript/bootstrap.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
.col-md-1, .col-md-2, .col-md-3, .col-md-4, .col-md-6, .col-md-8 {
color: black;
border: 1px solid black;
}
label { white-space: nowrap }
</style>
<script language="Javascript">

/* Note: Typing the enter key in any field of a form submits the form.
This can be suppressed by not using a form.*/

var suggest;

function setSearch() {
suggest = new AutoSuggest(document.getElementById('requestField'), bookNames);
document.getElementById("requestField").focus();
var viewportH = Math.floor(window.innerHeight * .7);
elem = document.getElementById("inputCell");
elem.style.height = viewportH;
};

function getDataToAdd(params) {
	  $.get(params,
	  function(data) {
	    var rep = document.getElementById("inputCell");
	    rep.innerHTML = data + rep.innerHTML;
	    document.getElementById("requestField").focus();
	  });
	};

function findPassage(elem) {
  if (!elem) { elem = document.getElementById("requestField"); }
  var selected = $('#checkboxes input:checked').map(function(i,el){return el.name;}).get().join(';'); 
  var params = "getRef.jsp?passage=" + encodeURI(elem.value)
    + "&lang=" + document.querySelector('input[name="lang"]:checked').value
    + ";" + encodeURI(selected);
  getDataToAdd(params);
};

function returned(value) {
  var rep = document.getElementById("inputCell");
  rep.innerHTML = value + rep.innerHTML;
};

function clearReturn() {
  var rep = document.getElementById("inputCell");
  rep.innerHTML = "&nbsp;";
  rep = document.getElementById("requestField");
  rep.value="";
  rep.focus();
};

/* The mouse clicks on a span which holds only the verse reference.
This span is inside a span which has the text as a mouse over target,
so its parent has the text as its target.*/

function hitSpan(elem, refID, vID) {
  var tit = elem.parentNode.title; // The text of the verse
  var htm = elem.innerHTML; // Reference to the verse, has a space at end
  var rep = document.getElementById("inputCell");
  rep.innerHTML = "<P>" + tit + " <b>" + htm + "</b></p>" + rep.innerHTML;
};

</script>

</HEAD>
<BODY onLoad='setSearch()' style="background-color:#E8E8E8;">
<a href="about.html">About Bible Cref and Contact Data</a>&nbsp;
<h1 align="center"><span class="bigger">S</span>imple
<span class="bigger">B</span>ible
<span class="bigger">C</span>orpus</h1>

<div id="sugRow" style="display: none; text-align: center; width: 100%;">
<span id="sugContent" style="">sugcontent</span></div>

<div class="container-fluid">
<div class="row">
<div class="col-md-6" id="radios">
<b>First language</b><br>
<%= MapLanguagesToTables.makeRadios() %>
</div>
<div class="col-md-6" id="checkboxes">
<b>Parallel language(s)</b><br>
<%= MapLanguagesToTables.makeCheckboxes() %>
</div>
</div>
<div class="row">
<div class="col-md-4"></div>
<div class="col-md-4">
<input type="text" name="requestField" id="requestField" value=""
title="Enter the book, chapter, and verse(s) for a scripture passage as in Re:20:10, then press Find or press the Enter key.">
<button type="reset" id="findBtn"  name="findBtn" class="btnBlue cursorHand"
title="Searches for the verse or passage named in the input box as in  Ge. 1:1-4"
onClick="javascript:findPassage()">Find Verses</button>
<button type="reset" id="clearBtn" name="clearBtn" class="btnRed cursorHand"
title="Clears the input field and the accumulated verses"
onClick="javascript:clearReturn()">Clear</button><br>
<div id="autosuggest"><ul></ul></div>
</div>
<div class="col-md-4"></div>
</div>
</div>
<table border="0" align="center" VALIGN="top" width="100%">
<tr><td colspan="1" bgcolor="black" height="6"></td></tr>
<tr><td><div id="inputCell" style="overflow: auto;" ></div></td></tr>
</table>
</BODY></HTML>
