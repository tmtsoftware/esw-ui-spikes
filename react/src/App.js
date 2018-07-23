import React, {Component} from 'react';
import './App.css';
import Connector from "./Connector";
import mysequencer from "mysequencer";

class App extends Component {
  render() {
    return (
        <div>
            {console.log(mysequencer.AA.dd())}
          <Connector/>
        </div>
    );
  }
}

export default App;
