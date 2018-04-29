<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->

<%-- check if there is a session scope variable user --%>
<c:if test="${empty sessionScope.user}">
  <%-- redirect to Login --%>
  <c:redirect url="../auth/Login" />
</c:if>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<title>Semester Page</title>
</head>
<body>
	<div class="container">
		<p class="text-right"><a href="../auth/Logout">Logout</a></p>
		<div class="row">
			<div class="col-6">
				<h2>Courses</h2>
				<ul>
					<c:forEach items="${user.semesters[semesterId].courses}" var="course" varStatus="status">
						<li><a href="CoursePage?semesterId=${semesterId}&courseId=${status.index}">${course.name} ${course.grade}</a></li>
					</c:forEach>
				</ul>
				<div class="row">
					<div class="col">
						<input type="text" class="form-control" name="course" placeholder="Name of Course">
					</div>
					<div class="col">
						<input type="text" maxlength="2" class="form-control" name="grade" placeholder="Grade">
					</div>
					<div class="col">
						<a class="btn btn-primary" href="#" role="button">Add Course</a>
					</div>
				</div>
			</div> 
			<div class="col-6">
				<h2>Dates</h2>
				<p>All your upcoming events go here.</p>
			</div>
		</div>
	</div>	
</body>

  <body class="college-gpa-calculator college-gpa-calculator_index" data-calculator='gpa'  itemscope itemtype="https://schema.org/WebPage">
 <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"> 

    <header class="body-header js-body-header">
      
<a href="/" class="menu-desktop__logo" itemprop="url">    


    
    <li class="menu-desktop__item">

</a>    </li>
  
 


  </ul>
</nav>
    </header>

    <main class="body-content js-body-content">
      

<header class="page-header">

    
 
</header>
<section class="page-section">
  <div class="page-calculator js-calculator">
    <ul class="page-semesters" id="js-semesters"></ul>
    <button class="page-calculator__button-create js-item-action" data-type="semester" data-action="create">Add Semester</button>
    <div class="page-calculator__output">
  <div class="page-calculator__meter">
    <div class="page-calculator__meter-outer"></div>
    <div class="page-calculator__meter-graph" id="js-calculator-graph" data-value="0">
        <span class="page-calculator__meter-slice page-calculator__meter-slice-1"></span>
        <span class="page-calculator__meter-slice page-calculator__meter-slice-2"></span>
        <span class="page-calculator__meter-slice page-calculator__meter-slice-3"></span>
        <span class="page-calculator__meter-slice page-calculator__meter-slice-4"></span>
        <span class="page-calculator__meter-slice page-calculator__meter-slice-5"></span>
        <span class="page-calculator__meter-slice page-calculator__meter-slice-6"></span>
        <span class="page-calculator__meter-slice page-calculator__meter-slice-7"></span>
        <span class="page-calculator__meter-slice page-calculator__meter-slice-8"></span>
        <span class="page-calculator__meter-slice page-calculator__meter-slice-9"></span>
        <span class="page-calculator__meter-slice page-calculator__meter-slice-10"></span>
        <span class="page-calculator__meter-slice page-calculator__meter-slice-11"></span>
        <span class="page-calculator__meter-slice page-calculator__meter-slice-12"></span>
        <span class="page-calculator__meter-slice page-calculator__meter-slice-13"></span>
        <span class="page-calculator__meter-slice page-calculator__meter-slice-14"></span>
        <span class="page-calculator__meter-slice page-calculator__meter-slice-15"></span>
        <span class="page-calculator__meter-slice page-calculator__meter-slice-16"></span>
        <span class="page-calculator__meter-slice page-calculator__meter-slice-17"></span>
        <span class="page-calculator__meter-slice page-calculator__meter-slice-18"></span>
    </div>
    <div class="page-calculator__meter-inner"></div>
  </div>
  <div class="page-calculator__masks"></div>
  <div class="page-calculator__icons"></div>
  <div class="page-calculator__output-text">
    <div class="page-calculator__output-value" id="js-cumulative-gpa">0</div>
    <div class="page-calculator__output-label">Cumulative GPA</div>
  </div>
</div>
  </div>
  <aside class="page-aside">
 
</section>

      
    
    
  </article>
  <aside class="page-aside"></aside>
</section>
    </main>



    <div class="body-template" id="js-assessment-template">
  <li class="page-block js-assessment">
  <input class="page-block__input page-block__input--name js-assessment-name js-store" type="text" placeholder="Assessment name" data-type="name" aria-label="Assessment name">
  <select class="page-block__select page-block__select--gradeLetter js-assessment-gradeLetter js-calculate js-store" data-type="gradeLetter" aria-label="Assessment letter grade">
    <option selected="selected" disabled="disabled" hidden="hidden">Letter</option>
    <option value="97">A+</option>
    <option value="93">A</option>
    <option value="90">A-</option>
    <option value="87">B+</option>
    <option value="83">B</option>
    <option value="80">B-</option>
    <option value="77">C+</option>
    <option value="73">C</option>
    <option value="70">C-</option>
    <option value="67">D+</option>
    <option value="63">D</option>
    <option value="60">D-</option>
    <option value="0">F</option>
  </select>
  <select class="page-block__select page-block__select--gradePercent js-assessment-gradePercent js-calculate js-store" data-type="gradePercent" aria-label="Assessment percent grade">
    <option selected="selected" disabled="disabled" hidden="hidden">Percent</option>
    <option value="100" data-letter-value="97">100</option>
    <option value="99" data-letter-value="97">99</option>
    <option value="98" data-letter-value="97">98</option>
    <option value="97" data-letter-value="97">97</option>
    <option value="96" data-letter-value="93">96</option>
    <option value="95" data-letter-value="93">95</option>
    <option value="94" data-letter-value="93">94</option>
    <option value="93" data-letter-value="93">93</option>
    <option value="92" data-letter-value="90">92</option>
    <option value="91" data-letter-value="90">91</option>
    <option value="90" data-letter-value="90">90</option>
    <option value="89" data-letter-value="87">89</option>
    <option value="88" data-letter-value="87">88</option>
    <option value="87" data-letter-value="87">87</option>
    <option value="86" data-letter-value="83">86</option>
    <option value="85" data-letter-value="83">85</option>
    <option value="84" data-letter-value="83">84</option>
    <option value="83" data-letter-value="83">83</option>
    <option value="82" data-letter-value="80">82</option>
    <option value="81" data-letter-value="80">81</option>
    <option value="80" data-letter-value="80">80</option>
    <option value="79" data-letter-value="77">79</option>
    <option value="78" data-letter-value="77">78</option>
    <option value="77" data-letter-value="77">77</option>
    <option value="76" data-letter-value="73">76</option>
    <option value="75" data-letter-value="73">75</option>
    <option value="74" data-letter-value="73">74</option>
    <option value="73" data-letter-value="73">73</option>
    <option value="72" data-letter-value="70">72</option>
    <option value="71" data-letter-value="70">71</option>
    <option value="70" data-letter-value="70">70</option>
    <option value="69" data-letter-value="67">69</option>
    <option value="68" data-letter-value="67">68</option>
    <option value="67" data-letter-value="67">67</option>
    <option value="66" data-letter-value="63">66</option>
    <option value="65" data-letter-value="63">65</option>
    <option value="64" data-letter-value="63">64</option>
    <option value="63" data-letter-value="63">63</option>
    <option value="62" data-letter-value="60">62</option>
    <option value="61" data-letter-value="60">61</option>
    <option value="60" data-letter-value="60">60</option>
  </select>
  <input class="page-block__input page-block__input--weight js-assessment-weight js-calculate js-store" type="number" placeholder="Weight" min="0" max="100" data-type="weight" aria-label="Assessment weight (percent)">
  <button class="page-block__button-remove js-item-action js-item-action-remove" data-type="assessment" data-action="remove" aria-label="Remove assessment"></button>
</li>
</div>
<div class="body-template" id="js-class-template">
  <li class="page-group js-class">
  <div class="page-group__header">
    <h3 class="page-group__title">Class</h3>
  </div>
  <button class="page-group__button-remove js-item-action" data-type="class" data-action="remove" aria-label="Remove class"></button>
  <ul class="page-blocks">
        <li class="page-block js-assessment">
  <input class="page-block__input page-block__input--name js-assessment-name js-store" type="text" placeholder="Assessment name" data-type="name" aria-label="Assessment name">
  <select class="page-block__select page-block__select--gradeLetter js-assessment-gradeLetter js-calculate js-store" data-type="gradeLetter" aria-label="Assessment letter grade">
    <option selected="selected" disabled="disabled" hidden="hidden">Letter</option>
    <option value="97">A+</option>
    <option value="93">A</option>
    <option value="90">A-</option>
    <option value="87">B+</option>
    <option value="83">B</option>
    <option value="80">B-</option>
    <option value="77">C+</option>
    <option value="73">C</option>
    <option value="70">C-</option>
    <option value="67">D+</option>
    <option value="63">D</option>
    <option value="60">D-</option>
    <option value="0">F</option>
  </select>
  <select class="page-block__select page-block__select--gradePercent js-assessment-gradePercent js-calculate js-store" data-type="gradePercent" aria-label="Assessment percent grade">
    <option selected="selected" disabled="disabled" hidden="hidden">Percent</option>
    <option value="100" data-letter-value="97">100</option>
    <option value="99" data-letter-value="97">99</option>
    <option value="98" data-letter-value="97">98</option>
    <option value="97" data-letter-value="97">97</option>
    <option value="96" data-letter-value="93">96</option>
    <option value="95" data-letter-value="93">95</option>
    <option value="94" data-letter-value="93">94</option>
    <option value="93" data-letter-value="93">93</option>
    <option value="92" data-letter-value="90">92</option>
    <option value="91" data-letter-value="90">91</option>
    <option value="90" data-letter-value="90">90</option>
    <option value="89" data-letter-value="87">89</option>
    <option value="88" data-letter-value="87">88</option>
    <option value="87" data-letter-value="87">87</option>
    <option value="86" data-letter-value="83">86</option>
    <option value="85" data-letter-value="83">85</option>
    <option value="84" data-letter-value="83">84</option>
    <option value="83" data-letter-value="83">83</option>
    <option value="82" data-letter-value="80">82</option>
    <option value="81" data-letter-value="80">81</option>
    <option value="80" data-letter-value="80">80</option>
    <option value="79" data-letter-value="77">79</option>
    <option value="78" data-letter-value="77">78</option>
    <option value="77" data-letter-value="77">77</option>
    <option value="76" data-letter-value="73">76</option>
    <option value="75" data-letter-value="73">75</option>
    <option value="74" data-letter-value="73">74</option>
    <option value="73" data-letter-value="73">73</option>
    <option value="72" data-letter-value="70">72</option>
    <option value="71" data-letter-value="70">71</option>
    <option value="70" data-letter-value="70">70</option>
    <option value="69" data-letter-value="67">69</option>
    <option value="68" data-letter-value="67">68</option>
    <option value="67" data-letter-value="67">67</option>
    <option value="66" data-letter-value="63">66</option>
    <option value="65" data-letter-value="63">65</option>
    <option value="64" data-letter-value="63">64</option>
    <option value="63" data-letter-value="63">63</option>
    <option value="62" data-letter-value="60">62</option>
    <option value="61" data-letter-value="60">61</option>
    <option value="60" data-letter-value="60">60</option>
  </select>
  <input class="page-block__input page-block__input--weight js-assessment-weight js-calculate js-store" type="number" placeholder="Weight" min="0" max="100" data-type="weight" aria-label="Assessment weight (percent)">
  <button class="page-block__button-remove js-item-action js-item-action-remove" data-type="assessment" data-action="remove" aria-label="Remove assessment"></button>
</li>
        <li class="page-block js-assessment">
  <input class="page-block__input page-block__input--name js-assessment-name js-store" type="text" placeholder="Assessment name" data-type="name" aria-label="Assessment name">
  <select class="page-block__select page-block__select--gradeLetter js-assessment-gradeLetter js-calculate js-store" data-type="gradeLetter" aria-label="Assessment letter grade">
    <option selected="selected" disabled="disabled" hidden="hidden">Letter</option>
    <option value="97">A+</option>
    <option value="93">A</option>
    <option value="90">A-</option>
    <option value="87">B+</option>
    <option value="83">B</option>
    <option value="80">B-</option>
    <option value="77">C+</option>
    <option value="73">C</option>
    <option value="70">C-</option>
    <option value="67">D+</option>
    <option value="63">D</option>
    <option value="60">D-</option>
    <option value="0">F</option>
  </select>
  <select class="page-block__select page-block__select--gradePercent js-assessment-gradePercent js-calculate js-store" data-type="gradePercent" aria-label="Assessment percent grade">
    <option selected="selected" disabled="disabled" hidden="hidden">Percent</option>
    <option value="100" data-letter-value="97">100</option>
    <option value="99" data-letter-value="97">99</option>
    <option value="98" data-letter-value="97">98</option>
    <option value="97" data-letter-value="97">97</option>
    <option value="96" data-letter-value="93">96</option>
    <option value="95" data-letter-value="93">95</option>
    <option value="94" data-letter-value="93">94</option>
    <option value="93" data-letter-value="93">93</option>
    <option value="92" data-letter-value="90">92</option>
    <option value="91" data-letter-value="90">91</option>
    <option value="90" data-letter-value="90">90</option>
    <option value="89" data-letter-value="87">89</option>
    <option value="88" data-letter-value="87">88</option>
    <option value="87" data-letter-value="87">87</option>
    <option value="86" data-letter-value="83">86</option>
    <option value="85" data-letter-value="83">85</option>
    <option value="84" data-letter-value="83">84</option>
    <option value="83" data-letter-value="83">83</option>
    <option value="82" data-letter-value="80">82</option>
    <option value="81" data-letter-value="80">81</option>
    <option value="80" data-letter-value="80">80</option>
    <option value="79" data-letter-value="77">79</option>
    <option value="78" data-letter-value="77">78</option>
    <option value="77" data-letter-value="77">77</option>
    <option value="76" data-letter-value="73">76</option>
    <option value="75" data-letter-value="73">75</option>
    <option value="74" data-letter-value="73">74</option>
    <option value="73" data-letter-value="73">73</option>
    <option value="72" data-letter-value="70">72</option>
    <option value="71" data-letter-value="70">71</option>
    <option value="70" data-letter-value="70">70</option>
    <option value="69" data-letter-value="67">69</option>
    <option value="68" data-letter-value="67">68</option>
    <option value="67" data-letter-value="67">67</option>
    <option value="66" data-letter-value="63">66</option>
    <option value="65" data-letter-value="63">65</option>
    <option value="64" data-letter-value="63">64</option>
    <option value="63" data-letter-value="63">63</option>
    <option value="62" data-letter-value="60">62</option>
    <option value="61" data-letter-value="60">61</option>
    <option value="60" data-letter-value="60">60</option>
  </select>
  <input class="page-block__input page-block__input--weight js-assessment-weight js-calculate js-store" type="number" placeholder="Weight" min="0" max="100" data-type="weight" aria-label="Assessment weight (percent)">
  <button class="page-block__button-remove js-item-action js-item-action-remove" data-type="assessment" data-action="remove" aria-label="Remove assessment"></button>
</li>
        <li class="page-block js-assessment">
  <input class="page-block__input page-block__input--name js-assessment-name js-store" type="text" placeholder="Assessment name" data-type="name" aria-label="Assessment name">
  <select class="page-block__select page-block__select--gradeLetter js-assessment-gradeLetter js-calculate js-store" data-type="gradeLetter" aria-label="Assessment letter grade">
    <option selected="selected" disabled="disabled" hidden="hidden">Letter</option>
    <option value="97">A+</option>
    <option value="93">A</option>
    <option value="90">A-</option>
    <option value="87">B+</option>
    <option value="83">B</option>
    <option value="80">B-</option>
    <option value="77">C+</option>
    <option value="73">C</option>
    <option value="70">C-</option>
    <option value="67">D+</option>
    <option value="63">D</option>
    <option value="60">D-</option>
    <option value="0">F</option>
  </select>
  <select class="page-block__select page-block__select--gradePercent js-assessment-gradePercent js-calculate js-store" data-type="gradePercent" aria-label="Assessment percent grade">
    <option selected="selected" disabled="disabled" hidden="hidden">Percent</option>
    <option value="100" data-letter-value="97">100</option>
    <option value="99" data-letter-value="97">99</option>
    <option value="98" data-letter-value="97">98</option>
    <option value="97" data-letter-value="97">97</option>
    <option value="96" data-letter-value="93">96</option>
    <option value="95" data-letter-value="93">95</option>
    <option value="94" data-letter-value="93">94</option>
    <option value="93" data-letter-value="93">93</option>
    <option value="92" data-letter-value="90">92</option>
    <option value="91" data-letter-value="90">91</option>
    <option value="90" data-letter-value="90">90</option>
    <option value="89" data-letter-value="87">89</option>
    <option value="88" data-letter-value="87">88</option>
    <option value="87" data-letter-value="87">87</option>
    <option value="86" data-letter-value="83">86</option>
    <option value="85" data-letter-value="83">85</option>
    <option value="84" data-letter-value="83">84</option>
    <option value="83" data-letter-value="83">83</option>
    <option value="82" data-letter-value="80">82</option>
    <option value="81" data-letter-value="80">81</option>
    <option value="80" data-letter-value="80">80</option>
    <option value="79" data-letter-value="77">79</option>
    <option value="78" data-letter-value="77">78</option>
    <option value="77" data-letter-value="77">77</option>
    <option value="76" data-letter-value="73">76</option>
    <option value="75" data-letter-value="73">75</option>
    <option value="74" data-letter-value="73">74</option>
    <option value="73" data-letter-value="73">73</option>
    <option value="72" data-letter-value="70">72</option>
    <option value="71" data-letter-value="70">71</option>
    <option value="70" data-letter-value="70">70</option>
    <option value="69" data-letter-value="67">69</option>
    <option value="68" data-letter-value="67">68</option>
    <option value="67" data-letter-value="67">67</option>
    <option value="66" data-letter-value="63">66</option>
    <option value="65" data-letter-value="63">65</option>
    <option value="64" data-letter-value="63">64</option>
    <option value="63" data-letter-value="63">63</option>
    <option value="62" data-letter-value="60">62</option>
    <option value="61" data-letter-value="60">61</option>
    <option value="60" data-letter-value="60">60</option>
  </select>
  <input class="page-block__input page-block__input--weight js-assessment-weight js-calculate js-store" type="number" placeholder="Weight" min="0" max="100" data-type="weight" aria-label="Assessment weight (percent)">
  <button class="page-block__button-remove js-item-action js-item-action-remove" data-type="assessment" data-action="remove" aria-label="Remove assessment"></button>
</li>
        <li class="page-block js-assessment">
  <input class="page-block__input page-block__input--name js-assessment-name js-store" type="text" placeholder="Assessment name" data-type="name" aria-label="Assessment name">
  <select class="page-block__select page-block__select--gradeLetter js-assessment-gradeLetter js-calculate js-store" data-type="gradeLetter" aria-label="Assessment letter grade">
    <option selected="selected" disabled="disabled" hidden="hidden">Letter</option>
    <option value="97">A+</option>
    <option value="93">A</option>
    <option value="90">A-</option>
    <option value="87">B+</option>
    <option value="83">B</option>
    <option value="80">B-</option>
    <option value="77">C+</option>
    <option value="73">C</option>
    <option value="70">C-</option>
    <option value="67">D+</option>
    <option value="63">D</option>
    <option value="60">D-</option>
    <option value="0">F</option>
  </select>
  <select class="page-block__select page-block__select--gradePercent js-assessment-gradePercent js-calculate js-store" data-type="gradePercent" aria-label="Assessment percent grade">
    <option selected="selected" disabled="disabled" hidden="hidden">Percent</option>
    <option value="100" data-letter-value="97">100</option>
    <option value="99" data-letter-value="97">99</option>
    <option value="98" data-letter-value="97">98</option>
    <option value="97" data-letter-value="97">97</option>
    <option value="96" data-letter-value="93">96</option>
    <option value="95" data-letter-value="93">95</option>
    <option value="94" data-letter-value="93">94</option>
    <option value="93" data-letter-value="93">93</option>
    <option value="92" data-letter-value="90">92</option>
    <option value="91" data-letter-value="90">91</option>
    <option value="90" data-letter-value="90">90</option>
    <option value="89" data-letter-value="87">89</option>
    <option value="88" data-letter-value="87">88</option>
    <option value="87" data-letter-value="87">87</option>
    <option value="86" data-letter-value="83">86</option>
    <option value="85" data-letter-value="83">85</option>
    <option value="84" data-letter-value="83">84</option>
    <option value="83" data-letter-value="83">83</option>
    <option value="82" data-letter-value="80">82</option>
    <option value="81" data-letter-value="80">81</option>
    <option value="80" data-letter-value="80">80</option>
    <option value="79" data-letter-value="77">79</option>
    <option value="78" data-letter-value="77">78</option>
    <option value="77" data-letter-value="77">77</option>
    <option value="76" data-letter-value="73">76</option>
    <option value="75" data-letter-value="73">75</option>
    <option value="74" data-letter-value="73">74</option>
    <option value="73" data-letter-value="73">73</option>
    <option value="72" data-letter-value="70">72</option>
    <option value="71" data-letter-value="70">71</option>
    <option value="70" data-letter-value="70">70</option>
    <option value="69" data-letter-value="67">69</option>
    <option value="68" data-letter-value="67">68</option>
    <option value="67" data-letter-value="67">67</option>
    <option value="66" data-letter-value="63">66</option>
    <option value="65" data-letter-value="63">65</option>
    <option value="64" data-letter-value="63">64</option>
    <option value="63" data-letter-value="63">63</option>
    <option value="62" data-letter-value="60">62</option>
    <option value="61" data-letter-value="60">61</option>
    <option value="60" data-letter-value="60">60</option>
  </select>
  <input class="page-block__input page-block__input--weight js-assessment-weight js-calculate js-store" type="number" placeholder="Weight" min="0" max="100" data-type="weight" aria-label="Assessment weight (percent)">
  <button class="page-block__button-remove js-item-action js-item-action-remove" data-type="assessment" data-action="remove" aria-label="Remove assessment"></button>
</li>
  </ul>
  <div class="page-group__output page-group__output--class js-class-grade">0</div>
  <button class="page-group__button-create js-item-action" data-type="assessment" data-action="create">Add assessment</button>
</li>
</div>
<div class="body-template" id="js-class-template--empty">
  <li class="page-group js-class">
  <div class="page-group__header">
    <h3 class="page-group__title">Class</h3>
  </div>
  <button class="page-group__button-remove js-item-action" data-type="class" data-action="remove" aria-label="Remove class"></button>
  <ul class="page-blocks">
  </ul>
  <div class="page-group__output page-group__output--class js-class-grade">0</div>
  <button class="page-group__button-create js-item-action" data-type="assessment" data-action="create">Add assessment</button>
</li>
</div>
<div class="body-template" id="js-course-template">
  <li class="page-block js-course">
  <input class="page-block__input page-block__input--name js-course-name js-store" type="text" placeholder="Course name" data-type="name" aria-label="Course name">
  <select class="page-block__select page-block__select--grade js-course-grade js-calculate js-store" data-type="grade" aria-label="Course grade">
    <option selected="selected" disabled="disabled" hidden="hidden">Grade</option>
    <option value="4.0">A+</option>
    <option value="4.0">A</option>
    <option value="3.7">A-</option>
    <option value="3.3">B+</option>
    <option value="3.0">B</option>
    <option value="2.7">B-</option>
    <option value="2.3">C+</option>
    <option value="2.0">C</option>
    <option value="1.7">C-</option>
    <option value="1.3">D+</option>
    <option value="1.0">D</option>
    <option value="0.7">D-</option>
    <option value="0.0">F</option>
  </select>
  <input class="page-block__input page-block__input--credits js-course-credits js-calculate js-store" type="number" placeholder="Credits" data-type="credits" aria-label="Course credits">
  <select class="page-block__select page-block__select--weight js-course-weight js-calculate js-store" disabled="disabled" data-type="weight" aria-label="Course weight">
    <option selected="selected" disabled="disabled" hidden="hidden">Weight</option>
    <option value="0.0">Regular</option>
    <option value="0.5">Honors</option>
    <option value="1.0">AP / IB</option>
    <option value="1.0">College</option>
  </select>
  <button class="page-block__button-remove js-item-action js-item-action-remove" data-type="course" data-action="remove" aria-label="Remove course"></button>
</li>
</div>
<div class="body-template" id="js-semester-template">
  <li class="page-group js-semester">
  <div class="page-group__header">
    <h3 class="page-group__title">Semester</h3>
    <div class="page-group__toggle">
      <span class="page-group__toggle-title">Weighted</span>
      <span class="page-group__toggle-button">
        <input class="page-group__toggle-input js-weight-toggle" id="toggle" type="checkbox" value="off" data-type="weightToggle">
        <label class="page-group__toggle-label js-weight-toggle-label" for="toggle">Toggle</label>
      </span>
    </div>
  </div>
  <button class="page-group__button-remove js-item-action" data-type="semester" data-action="remove" aria-label="Remove semester"></button>
  <ul class="page-blocks">
        <li class="page-block js-course">
  <input class="page-block__input page-block__input--name js-course-name js-store" type="text" placeholder="Course name" data-type="name" aria-label="Course name">
  <select class="page-block__select page-block__select--grade js-course-grade js-calculate js-store" data-type="grade" aria-label="Course grade">
    <option selected="selected" disabled="disabled" hidden="hidden">Grade</option>
    <option value="4.0">A+</option>
    <option value="4.0">A</option>
    <option value="3.7">A-</option>
    <option value="3.3">B+</option>
    <option value="3.0">B</option>
    <option value="2.7">B-</option>
    <option value="2.3">C+</option>
    <option value="2.0">C</option>
    <option value="1.7">C-</option>
    <option value="1.3">D+</option>
    <option value="1.0">D</option>
    <option value="0.7">D-</option>
    <option value="0.0">F</option>
  </select>
  <input class="page-block__input page-block__input--credits js-course-credits js-calculate js-store" type="number" placeholder="Credits" data-type="credits" aria-label="Course credits">
  <select class="page-block__select page-block__select--weight js-course-weight js-calculate js-store" disabled="disabled" data-type="weight" aria-label="Course weight">
    <option selected="selected" disabled="disabled" hidden="hidden">Weight</option>
    <option value="0.0">Regular</option>
    <option value="0.5">Honors</option>
    <option value="1.0">AP / IB</option>
    <option value="1.0">College</option>
  </select>
  <button class="page-block__button-remove js-item-action js-item-action-remove" data-type="course" data-action="remove" aria-label="Remove course"></button>
</li>
        <li class="page-block js-course">
  <input class="page-block__input page-block__input--name js-course-name js-store" type="text" placeholder="Course name" data-type="name" aria-label="Course name">
  <select class="page-block__select page-block__select--grade js-course-grade js-calculate js-store" data-type="grade" aria-label="Course grade">
    <option selected="selected" disabled="disabled" hidden="hidden">Grade</option>
    <option value="4.0">A+</option>
    <option value="4.0">A</option>
    <option value="3.7">A-</option>
    <option value="3.3">B+</option>
    <option value="3.0">B</option>
    <option value="2.7">B-</option>
    <option value="2.3">C+</option>
    <option value="2.0">C</option>
    <option value="1.7">C-</option>
    <option value="1.3">D+</option>
    <option value="1.0">D</option>
    <option value="0.7">D-</option>
    <option value="0.0">F</option>
  </select>
  <input class="page-block__input page-block__input--credits js-course-credits js-calculate js-store" type="number" placeholder="Credits" data-type="credits" aria-label="Course credits">
  <select class="page-block__select page-block__select--weight js-course-weight js-calculate js-store" disabled="disabled" data-type="weight" aria-label="Course weight">
    <option selected="selected" disabled="disabled" hidden="hidden">Weight</option>
    <option value="0.0">Regular</option>
    <option value="0.5">Honors</option>
    <option value="1.0">AP / IB</option>
    <option value="1.0">College</option>
  </select>
  <button class="page-block__button-remove js-item-action js-item-action-remove" data-type="course" data-action="remove" aria-label="Remove course"></button>
</li>
        <li class="page-block js-course">
  <input class="page-block__input page-block__input--name js-course-name js-store" type="text" placeholder="Course name" data-type="name" aria-label="Course name">
  <select class="page-block__select page-block__select--grade js-course-grade js-calculate js-store" data-type="grade" aria-label="Course grade">
    <option selected="selected" disabled="disabled" hidden="hidden">Grade</option>
    <option value="4.0">A+</option>
    <option value="4.0">A</option>
    <option value="3.7">A-</option>
    <option value="3.3">B+</option>
    <option value="3.0">B</option>
    <option value="2.7">B-</option>
    <option value="2.3">C+</option>
    <option value="2.0">C</option>
    <option value="1.7">C-</option>
    <option value="1.3">D+</option>
    <option value="1.0">D</option>
    <option value="0.7">D-</option>
    <option value="0.0">F</option>
  </select>
  <input class="page-block__input page-block__input--credits js-course-credits js-calculate js-store" type="number" placeholder="Credits" data-type="credits" aria-label="Course credits">
  <select class="page-block__select page-block__select--weight js-course-weight js-calculate js-store" disabled="disabled" data-type="weight" aria-label="Course weight">
    <option selected="selected" disabled="disabled" hidden="hidden">Weight</option>
    <option value="0.0">Regular</option>
    <option value="0.5">Honors</option>
    <option value="1.0">AP / IB</option>
    <option value="1.0">College</option>
  </select>
  <button class="page-block__button-remove js-item-action js-item-action-remove" data-type="course" data-action="remove" aria-label="Remove course"></button>
</li>
        <li class="page-block js-course">
  <input class="page-block__input page-block__input--name js-course-name js-store" type="text" placeholder="Course name" data-type="name" aria-label="Course name">
  <select class="page-block__select page-block__select--grade js-course-grade js-calculate js-store" data-type="grade" aria-label="Course grade">
    <option selected="selected" disabled="disabled" hidden="hidden">Grade</option>
    <option value="4.0">A+</option>
    <option value="4.0">A</option>
    <option value="3.7">A-</option>
    <option value="3.3">B+</option>
    <option value="3.0">B</option>
    <option value="2.7">B-</option>
    <option value="2.3">C+</option>
    <option value="2.0">C</option>
    <option value="1.7">C-</option>
    <option value="1.3">D+</option>
    <option value="1.0">D</option>
    <option value="0.7">D-</option>
    <option value="0.0">F</option>
  </select>
  <input class="page-block__input page-block__input--credits js-course-credits js-calculate js-store" type="number" placeholder="Credits" data-type="credits" aria-label="Course credits">
  <select class="page-block__select page-block__select--weight js-course-weight js-calculate js-store" disabled="disabled" data-type="weight" aria-label="Course weight">
    <option selected="selected" disabled="disabled" hidden="hidden">Weight</option>
    <option value="0.0">Regular</option>
    <option value="0.5">Honors</option>
    <option value="1.0">AP / IB</option>
    <option value="1.0">College</option>
  </select>
  <button class="page-block__button-remove js-item-action js-item-action-remove" data-type="course" data-action="remove" aria-label="Remove course"></button>
</li>
  </ul>
  <div class="page-group__output page-group__output--semester js-semester-gpa">0</div>
  <button class="page-group__button-create js-item-action" data-type="course" data-action="create">Add Course</button>
</li>
</div>
<div class="body-template" id="js-semester-template--empty">
  <li class="page-group js-semester">
  <div class="page-group__header">
    <h3 class="page-group__title">Semester</h3>
    <div class="page-group__toggle">
      <span class="page-group__toggle-title">Weighted</span>
      <span class="page-group__toggle-button">
        <input class="page-group__toggle-input js-weight-toggle" id="toggle" type="checkbox" value="off" data-type="weightToggle">
        <label class="page-group__toggle-label js-weight-toggle-label" for="toggle">Toggle</label>
      </span>
    </div>
  </div>
  <button class="page-group__button-remove js-item-action" data-type="semester" data-action="remove" aria-label="Remove semester"></button>
  <ul class="page-blocks">
  </ul>
  <div class="page-group__output page-group__output--semester js-semester-gpa">0</div>
  <button class="page-group__button-create js-item-action" data-type="course" data-action="create">Add Course</button>
</li>
</div>

  <script src="<c:url value="/resources/javascript/app.js" />"></script>

    <script>
      if ('serviceWorker' in navigator) {
        navigator.serviceWorker.register('/service-worker-0809e50c.js').then(function() { console.log('[ServiceWorker] Register'); });
      }
    </script>

    <script>
      (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
      (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
      m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
      })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');
      ga('create', 'UA-109239788-1', 'auto');
      ga('require', 'linkid');
      ga('send', 'pageview');
    </script>
  </body>

</html>