//client side validation in register form
const fnameEl = document.querySelector('#fname');
const lnameEl = document.querySelector('#lname');
const NICEl = document.querySelector('#NIC');
const basicSalaryEl = document.querySelector('#basicSalary');
const mobileEl = document.querySelector('#mobile');
const addressEl = document.querySelector('#address');
const emailEl = document.querySelector('#email');
const DOBEl = document.querySelector('#DOB');


const form = document.querySelector('#signup');


const checkFname = () => {

    let valid = false;

    const min = 3,
        max = 25;

    const fname = fnameEl.value.trim();

    if (!isRequired(fname)) {
        showError(fnameEl, 'First name cannot be blank.');
    }if (!isNaN(fname)) {
        showError(fnameEl, 'First name cannot be number');
    } else {
        showSuccess(fnameEl);
        valid = true;
    }
    return valid;
};


const checkLname = () => {

    let valid = false;

    const min = 3,
        max = 25;

    const lname = lnameEl.value.trim();
    if (!isNaN(lname)) {
        showError(lnameEl, 'last name cannot be number');
    }
    if (!isRequired(lname)) {
        showError(lnameEl, 'Last name cannot be blank.');
    } else if (!isBetween(lname.length, min, max)) {
        showError(lnameEl, `Username must be between ${min} and ${max} characters.`)
    } else {
        showSuccess(lnameEl);
        valid = true;
    }
    return valid;
};

const checkNIC = () => {

    let valid = false;

    const min = 3,
        max = 25;

    const NIC = NICEl.value.trim();

    if (!isRequired(NIC)) {
        showError(NICEl, 'NIC cannot be blank.');
    }  else {
        showSuccess(NICEl);
        valid = true;
    }
    return valid;
};

const checkBasicSalary = () => {

    let valid = false;

    const min = 3,
        max = 25;

    const basicSalary = basicSalaryEl.value.trim();

    if (!isRequired(basicSalary)) {
        showError(basicSalaryEl, 'Basic Salary cannot be blank.');
    } else {
        showSuccess(basicSalaryEl);
        valid = true;
    }
    return valid;
};

const checkMobile = () => {

    let valid = false;

    const min = 3,
        max = 25;

    const mobile = mobileEl.value.trim();

    if (!isRequired(mobile)) {
        showError(mobileEl, 'Mobile cannot be blank.');
    }
    if (isNaN(mobile)) {
        showError(mobileEl, 'Mobile must be a number.');
    }else {
        showSuccess(mobileEl);
        valid = true;
    }
    return valid;
};

const checkEmail = () => {
    let valid = false;
    const email = emailEl.value.trim();
    if (!isRequired(email)) {
        showError(emailEl, 'Email cannot be blank.');
    } else {
        showSuccess(emailEl);
        valid = true;
    }
    return valid;
};

const checkAddress = () => {

    let valid = false;

    const min = 3,
        max = 25;

    const address = addressEl.value.trim();

    if (!isRequired(address)) {
        showError(addressEl, 'Address cannot be blank.');
    } else {
        showSuccess(addressEl);
        valid = true;
    }
    return valid;
};

const checkDOB= () => {
    let valid = false;
    let today = new Date();

    today.setDate(0);
    today.setHours(0);
    today.setMinutes(0);
    today.setSeconds(0);
    today.setMilliseconds(0);
    today = today.getDate();


    const DOB = DOBEl.value.trim();

    if (!isRequired(DOB)) {
        showError(DOBEl, 'Date of Birth cannot be blank.');
    }

    if(DOB > today)
    {
        showError(DOBEl, 'Date of Birth cannot be future date');
    }
    else {
        showSuccess(DOBEl);
        valid = true;
    }

    return valid;
};


const isEmailValid = (email) => {
    const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
};


const isRequired = value => value === '' ? false : true;
const isBetween = (length, min, max) => length < min || length > max ? false : true;


const showError = (input, message) => {
    // get the form-field element
    const formField = input.parentElement;
    // add the error class
    formField.classList.remove('success');
    formField.classList.add('error');

    // show the error message
    const error = formField.querySelector('small');
    error.textContent = message;
};

const showSuccess = (input) => {
    // get the form-field element
    const formField = input.parentElement;

    // remove the error class
    formField.classList.remove('error');
    formField.classList.add('success');

    // hide the error message
    const error = formField.querySelector('small');
    error.textContent = '';
}


form.addEventListener('submit', function (e) {
    // prevent the form from submitting
    e.preventDefault();

    // validate fields
    let isFnameValid = checkFname(),
        isLnameValid = checkLname(),
        isDOBValid = checkDOB(),
        isNICValid = checkNIC(),
        isBasicSalaryValid=checkBasicSalary(),
        isMobileValid = checkMobile(),
        isEmailValid = checkEmail(),
        isAddressValid =checkAddress();

    let isFormValid = isFnameValid &&
        isLnameValid&&
        isDOBValid&&
        isNICValid&&
        isBasicSalaryValid&&
        isEmailValid &&
        isMobileValid&&
        isAddressValid;

    // submit to the server if the form is valid
    if (isFormValid) {
        form.submit();
    }
});


const debounce = (fn, delay = 500) => {
    let timeoutId;
    return (...args) => {
        // cancel the previous timer
        if (timeoutId) {
            clearTimeout(timeoutId);
        }
        // setup a new timer
        timeoutId = setTimeout(() => {
            fn.apply(null, args)
        }, delay);
    };
};

form.addEventListener('input', debounce(function (e) {
    switch (e.target.id) {
        case 'fname':
            checkFname();
            break;
        case 'lname':
            checkLname();
            break;
        case 'DOB':
            checkDOB();
            break;
        case 'email':
            checkEmail();
            break;
        case 'mobile':
            checkMobile();
            break;
        case 'NIC':
            checkNIC();
            break;
        case 'basicSalary':
            checkBasicSalary();
            break;
        case 'address':
            checkAddress();
            break;

    }
}));
