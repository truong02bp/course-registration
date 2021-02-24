import React, { useMemo } from "react";
import { connect } from "react-redux";
import * as actions from '../categories/actions';
import * as toast from '../../common/toast';

function RegisTable(props) {

  const { chosenSubject, cart } = props;

  const weekArray = useMemo(() => {
    let arr = []
    cart.forEach(item => {
      item.details.forEach(d => {
        let elm = {
          name: item.subject.name,
          timeName: d.time.name,
          lesson: d.time.lesson,
          weeks: d.weeks
        }
        arr.push(elm)
      })
    })
    return arr;
  }, [cart])

  const onUpdateCart = (sub) => {
    if(sub.slot === 0){
      toast.errNotify("Môn học đã hết !");
    }
    else{
      if (sub.isSame === "") {
        sub.isAdded = false;
        props.onUpdateCart({ ...sub });
      }
      else {
        toast.errNotify(`Trùng lịch với ${sub.isSame}`);
      }
    }
  }

  const changeTrColor = (sub) => {
    if (sub.isAdded === true) {
      return "table-success";
    } else if (sub.slot === 0) {
      return "table-active";
    }
    else if (sub.isSame !== "") {
      return "table-danger"
    }
    return "";
  };

  const checkChosenSubject = () => {
    chosenSubject.forEach((sub) => {
      sub.isAdded = false;
      if (cart) {
        cart.forEach((item) => {
          if (parseInt(item.id) === parseInt(sub.id)) {
            sub.isAdded = true;
          }
        });
      }
    });
  };

  const checkSameDaySubject = () => {
    chosenSubject.forEach((sub) => {
      sub.isSame = "";
      if (weekArray.length > 0) {
        sub.details.forEach(d => {
          weekArray.forEach((item) => {
            //check trung time va lesson
            if (item.timeName === d.time.name && item.lesson === parseInt(d.time.lesson)) {
              //check trung ten mon hoc
              if (item.name !== sub.subject.name) {
                //check trung weeks
                d.weeks.forEach(w => {
                  if(item.weeks.includes(w)){
                    sub.isSame = item.name;
                  }
                })
              }
            }
          })
        })
      }
    })
  }

  checkChosenSubject();
  checkSameDaySubject();

  const mapStartDay = (sub) => {
    return sub.map((item) => {
      return <p>{item.time.name}</p>;
    });
  };

  const mapLessionQuantity = (sub) => {
    return sub.map((item) => {
      return <p>2</p>;
    });
  };

  const mapStartLession = (sub) => {
    return sub.map((item) => {
      return <p>{item.time.lesson}</p>;
    });
  };

  const mapRoom = (sub) => {
    return sub.map((item) => {
      return <p>{item.room.name}</p>;
    });
  };

  const mapProfessor = (sub) => {
    return sub.map((item) => {
      return <p>{item.professor.name}</p>;
    });
  };

  const mapWeek = (sub) => {
    return sub.map(item => {
      return <p>{item.weeks.toString()}</p>;
    })
  };

  const mapListToTable = chosenSubject.map((sub, index) => {
    return (
      <tr
        key={Date.now().toString() + index}
        className={changeTrColor(sub)}>
        <td>
          <button
            className="btn btn-outline-dark"
            onClick={() => onUpdateCart(sub)}
            data-toggle="tooltip"
            title={`Trùng lịch với ${sub.isSame}`}
            disabled={sub.slot ? false : true}
          >
            {sub.isAdded === true ? "Delete" : "Add"}
          </button>
        </td>
        <td className="unimportant">{sub.subject.code}</td>
        <td className="unimportant">{sub.subject.name}</td>
        <td>{sub.nmh}</td>
        <td>{sub.tth === 0 ? "null" : sub.tth}</td>
        <td className="unimportant">{sub.subject.credit}</td>
        <td className="unimportant">{sub.quantity}</td>
        <td>{sub.slot}</td>
        <td>{sub.details && mapStartDay(sub.details)}</td>
        <td>{sub.details && mapStartLession(sub.details)}</td>
        <td className="unimportant">{sub.details && mapLessionQuantity(sub.details)}</td>
        <td className="unimportant">{sub.details && mapRoom(sub.details)}</td>
        <td>{sub.details && mapProfessor(sub.details)}</td>
        <td>{sub.details && mapWeek(sub.details)}</td>
      </tr>
    );
  });

  return (
    <div style={{ margin: "0 20px" }}>
      <div
        className="table-responsive"
        style={{ maxHeight: 400, overflow: "auto", minHeight: 200}}
      >
        {
          chosenSubject.length > 0 &&
          <table className="table regis-table table-bordered">
            <thead className="thead-dark">
              <tr>
                <th>Act</th>
                <th className="unimportant">Code</th>
                <th style={{minWidth: 200}} className="unimportant">Name</th>
                <th>ID</th>
                <th>PG</th>
                <th className="unimportant">Crt</th>
                <th className="unimportant">Qtt</th>
                <th>Slot</th>
                <th>Day</th>
                <th>Start</th>
                <th className="unimportant">Les</th>
                <th className="unimportant">Room</th>
                <th>Professor</th>
                <th>Week</th>
              </tr>
            </thead>
            <tbody>{chosenSubject.length > 0 && mapListToTable}</tbody>
          </table>
        }
      </div>
    </div>
  );
}

const mapState = state => {
  return {
    cart: state.cart,
    chosenSubject: state.chosenSubject
  }
}

const mapDispatch = dispatch => {
  return {
    onUpdateCart: (sub) => {
      dispatch(actions.updateCart(sub))
    }
  }
}

export default connect(mapState, mapDispatch)(RegisTable);
