import boy_toddler from '../assets/boy_toddler.svg'
import girl_toddler from '../assets/girl_toddler.svg'

function ChildInfo(){
    const info={gender:'f',full_name:'doha hamami',age:3}
    return (
        
        <div className="child-info-container">
        <div className='card-icon'>
            {info.gender=='f'?<img src={boy_toddler} width={90} height={90}/> : <img src={girl_toddler} height={80} width={80}/>}
        </div>
        <div className='child-info'>
          <span><strong>{info.full_name}</strong></span>
          <p>{info.age} months</p>
          <div className="progress-wrapper">
          <div className="progress-bar" style={{width: `${60}%`}}></div>
          </div>
        </div>
        
        </div>
    )
}
export default ChildInfo;