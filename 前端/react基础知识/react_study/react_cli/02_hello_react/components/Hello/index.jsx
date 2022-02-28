import React,{Component} from 'react'
import styles from "./index.module.css"

export default class Hello extends Component {
    render() {
        return <h2 className={styles.title}>Hello,React!</h2>
    }
}