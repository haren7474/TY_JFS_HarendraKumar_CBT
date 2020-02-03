import { User } from './users';

export interface PersonalDetail {
    personalDetailId: number;
    firstName: string;
    middleName: string;
    lastName: string;
    mobile: number;
    graduationDegree: string;
    degreeBranch: string;
    totalExperience: number;
    relaventExperience: number;
    userBean: User;
}
