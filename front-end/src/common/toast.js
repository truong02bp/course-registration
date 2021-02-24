import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

export const successNotify = (message)=> toast.info(message);
export const errNotify = (message)=> toast.error(message);
export const warningNotify = (message)=> toast.warning(message);