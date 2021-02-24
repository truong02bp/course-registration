import React from 'react';
import Logo from './../../assets/images/ptit-logo.jpg';
import './style.css';

function About() {
    return(
        <div className="about">
            <img src={Logo} style={{width: 150, marginBottom: 40}} alt=""></img>
            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d59604.642588676!2d105.75210207910158!3d20.981002800000017!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135ade1a3c1bb5d%3A0x5672057fb1892ed3!2zSOG7jWMgVmnhu4duIEPDtG5nIG5naOG7hyBCxrB1IENow61uaCBWaeG7hW4gVGjDtG5n!5e0!3m2!1svi!2s!4v1600165893990!5m2!1svi!2s" width={650} height={300} frameBorder={0} style={{border:0}} aria-hidden="false" tabIndex={0} title="ptit-map"
            ></iframe>
        </div>
    )
}

export default About;