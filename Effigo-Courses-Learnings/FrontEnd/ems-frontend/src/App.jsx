import './App.css'
import EmployeeComponent from './components/EmployeeComponent'
import FooterComponent from './components/FooterComponent'
import HeaderComponent from './components/HeaderComponent'
import ListEmployeecomponent from './components/ListEmployeecomponent'
import {BrowserRouter , Routes , Route} from 'react-router-dom'

function App() {


  return (
    <>
    <BrowserRouter>       
    {/* jb hum 1st time uss port pr jate h jb use hota h */}
     <HeaderComponent/>
       <Routes>    
        {/* reload nhi hota , alg alg route me switch ho jata hai */}
        {/* // https://localhost:3000  */}
        <Route path='/' element ={<ListEmployeecomponent/>}></Route>
        {/* // https://localhost:3000/employees  */}
        <Route path='/employees' element = {<ListEmployeecomponent/>}></Route>
       {/* // https://localhost:3000/add-employee */}
       <Route path='/add-employee' element = {<EmployeeComponent/>}></Route>
        {/* // https://localhost:3000/edit-employee/{id} */}
        <Route path='/edit-employee/:id' element ={<EmployeeComponent/>}></Route>
       </Routes>

     <FooterComponent/>
     </BrowserRouter>
    </>
  )
}

export default App
